package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.LoginResponse;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 会员登录接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:20
 * @modify
 **/
@Component
public class LoginSendService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送会员登录
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public LoginResponse execute(LoginRequest request) throws TranFailException {
        logger.info("LoginRequestService.execute: request:{}", request);

        try {
            LoginResponse response = HttpUtil.callHostServerByPost(true, "G://tmp//1.txt",
                    "UTF-8", request, "/sys/login",LoginResponse.class);

            String resultCode = response.getResultCode();
            if(!"0".equals(resultCode)) {
                throw new TranFailException(resultCode, response.getResultMsg());
            }

            return response;
        } catch (BaseException e) {
            logger.error("LoginPasswordModifyService.BaseException: e:{}", e);
            throw e;
        } catch (Exception e) {
            logger.error("LoginPasswordModifyService.Exception: e:{}", e);
            throw new TranFailException(ApplicationErrorCode.SYSTEM_ERROR, "交易异常");
        }
    }
}
