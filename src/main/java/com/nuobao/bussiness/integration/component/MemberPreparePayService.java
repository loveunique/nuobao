package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MemberInfoModifyRequest;
import com.nuobao.bussiness.integration.request.MemberPreparePayRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.MemberPreparePayResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建普通会员开通为诺星会员
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MemberPreparePayService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送普通会员开通为诺星会员
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public MemberPreparePayResponse execute(MemberPreparePayRequest request) throws Exception {
        logger.info("MemberPreparePayService.execute: request:{}", request);

        MemberPreparePayResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, MemberPreparePayResponse.class);

        return response;
    }
}
