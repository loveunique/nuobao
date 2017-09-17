package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MobileChangeRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建注册手机号码更换
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MobileChangeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送注册手机号码更换
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(MobileChangeRequest request) throws Exception {
        logger.info("MobileChangeRequestService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
