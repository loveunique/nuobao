package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginPasswordResetRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建重置会员登录密码Service
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:12
 * @modify
 **/
@Component
public class LoginPasswordResetService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送重置会员登录密码
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(LoginPasswordResetRequest request) throws Exception {
        logger.info("LoginPasswordResetService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, BaseResponse.class);

        return response;
    }
}
