package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.TranDetailQueryRequest;
import com.nuobao.bussiness.integration.request.TransferRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.TranDetailQueryResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 诺宝交易明细查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:20
 * @modify
 **/
@Component
public class TranDetailQueryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺宝交易明细查询
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public TranDetailQueryResponse execute(TranDetailQueryRequest request) throws Exception {
        logger.info("TransferService.execute: request:{}", request);

        TranDetailQueryResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, TranDetailQueryResponse.class);

        return response;
    }
}
