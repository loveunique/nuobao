package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginPasswordResetRequest;
import com.nuobao.bussiness.integration.request.TradePasswordResetRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建会员交易密码重置Service
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:12
 * @modify
 **/
@Component
public class TradePasswordResetService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送会员交易密码重置
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(TradePasswordResetRequest request) throws TranFailException {
        logger.info("TradePasswordResetService.execute: request:{}", request);

        try {
            BaseResponse response = HttpUtil.callHostServerByPost(false, null,
                    "UTF-8", request, "/sys/tran_pwd_reset",BaseResponse.class);

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
