package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginPasswordModifyRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建登录密码修改Service
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:12
 * @modify
 **/
@Component
public class LoginPasswordModifyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送密码修改
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(LoginPasswordModifyRequest request) throws TranFailException {
        logger.info("LoginPasswordModifyService.execute: request:{}", request);

        try {
            BaseResponse response = HttpUtil.callHostServerByPost(true, "/vm/a.txt",
                    "UTF-8", request, "/sys/login_pwd_modify",BaseResponse.class);

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
