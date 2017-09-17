package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginRequest;
import com.nuobao.bussiness.integration.request.TransferRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.LoginResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 诺宝转账
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:20
 * @modify
 **/
@Component
public class TransferService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺宝转账
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(TransferRequest request) throws Exception {
        logger.info("TransferService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
