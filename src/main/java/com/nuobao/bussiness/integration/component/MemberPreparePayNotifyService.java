package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MemberPreparePayNotifyRequest;
import com.nuobao.bussiness.integration.request.MemberPreparePayRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.MemberPreparePayResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建诺星会员开通支付结果通知
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MemberPreparePayNotifyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送诺星会员开通支付结果通知
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(MemberPreparePayNotifyRequest request) throws Exception {
        logger.info("MemberPreparePayNotifyService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
