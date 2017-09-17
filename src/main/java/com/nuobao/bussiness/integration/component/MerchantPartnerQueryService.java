package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MerchantInfoQueryRequest;
import com.nuobao.bussiness.integration.request.MerchantPartnerQueryRequest;
import com.nuobao.bussiness.integration.response.MemberInfoQueryResponse;
import com.nuobao.bussiness.integration.response.MerchantPartnerQueryResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建诺宝往来伙伴查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MerchantPartnerQueryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺宝往来伙伴查询
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public MerchantPartnerQueryResponse execute(MerchantPartnerQueryRequest request) throws Exception {
        logger.info("MerchantInfoQueryService.execute: request:{}", request);

        MerchantPartnerQueryResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, MerchantPartnerQueryResponse.class);

        return response;
    }
}
