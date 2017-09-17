package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MemberPreparePayNotifyRequest;
import com.nuobao.bussiness.integration.request.MerchantIdentityRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
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
    public BaseResponse execute(MerchantIdentityRequest request) throws Exception {
        logger.info("MerchantIdentityService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
