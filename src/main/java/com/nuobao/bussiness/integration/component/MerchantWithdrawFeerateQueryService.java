package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MerchantWithdrawFeerateQueryRequest;
import com.nuobao.bussiness.integration.response.MerchantWithdrawFeerateQueryResponse;
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
public class MerchantWithdrawFeerateQueryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺宝提现税率查询
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public MerchantWithdrawFeerateQueryResponse execute(MerchantWithdrawFeerateQueryRequest request) throws Exception {
        logger.info("MerchantWithdrawFeerateQueryService.execute: request:{}", request);

        MerchantWithdrawFeerateQueryResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, MerchantWithdrawFeerateQueryResponse.class);

        return response;
    }
}
