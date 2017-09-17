package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginPasswordModifyRequest;
import com.nuobao.bussiness.integration.request.TradePasswordModifyRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建会员交易密码修改Service
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:12
 * @modify
 **/
@Component
public class TradePasswordModifyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送会员交易密码修改
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(TradePasswordModifyRequest request) throws Exception {
        logger.info("TradePasswordModifyService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
