package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginPasswordResetRequest;
import com.nuobao.bussiness.integration.request.TradePasswordResetRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建会员交易密码重置Service
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:12
 * @modify
 **/
@Component
public class TradePasswordResetService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送会员交易密码重置
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(TradePasswordResetRequest request) throws Exception {
        logger.info("TradePasswordResetService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
