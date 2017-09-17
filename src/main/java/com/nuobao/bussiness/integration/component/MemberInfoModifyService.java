package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MemberInfoModifyRequest;
import com.nuobao.bussiness.integration.request.MobileChangeRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建会员信息更新
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MemberInfoModifyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送会员信息更新
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(MemberInfoModifyRequest request) throws Exception {
        logger.info("MemberInfoModifyService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
