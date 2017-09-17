package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MerchantIdentityRequest;
import com.nuobao.bussiness.integration.request.MerchantInfoQueryRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.MemberInfoQueryResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建诺商认证信息查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MerchantInfoQueryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺商认证信息查询
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public MemberInfoQueryResponse execute(MerchantInfoQueryRequest request) throws Exception {
        logger.info("MerchantInfoQueryService.execute: request:{}", request);

        MemberInfoQueryResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, MemberInfoQueryResponse.class);

        return response;
    }
}
