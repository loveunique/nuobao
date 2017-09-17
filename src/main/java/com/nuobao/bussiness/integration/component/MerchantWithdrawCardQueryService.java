package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MerchantInfoQueryRequest;
import com.nuobao.bussiness.integration.request.MerchantWithdrawCardQueryRequest;
import com.nuobao.bussiness.integration.response.MemberInfoQueryResponse;
import com.nuobao.bussiness.integration.response.MerchantWithdrawCardQueryResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建诺宝提现银行卡查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MerchantWithdrawCardQueryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺宝提现银行卡查询
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public MerchantWithdrawCardQueryResponse execute(MerchantWithdrawCardQueryRequest request) throws Exception {
        logger.info("MerchantWithdrawCardQueryService.execute: request:{}", request);

        MerchantWithdrawCardQueryResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, MerchantWithdrawCardQueryResponse.class);

        return response;
    }
}
