package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MemberPreparePayNotifyRequest;
import com.nuobao.bussiness.integration.request.MerchantIdentityRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建诺商认证
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MerchantIdentityService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺商认证
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(MerchantIdentityRequest request) throws TranFailException {
        logger.info("MerchantIdentityService.execute: request:{}", request);

        try {
            BaseResponse response = HttpUtil.callHostServerByPost(false, null,
                    "UTF-8", request, "/mem/ns_identify",BaseResponse.class);

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
