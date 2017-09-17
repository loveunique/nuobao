package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MerchantChargeNotifyRequest;
import com.nuobao.bussiness.integration.request.MerchantChargeRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建诺宝充值支付结果通知
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MerchantChargeNotifyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺宝充值支付结果通知
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(MerchantChargeNotifyRequest request) throws Exception {
        logger.info("MerchantChargeNotifyService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
