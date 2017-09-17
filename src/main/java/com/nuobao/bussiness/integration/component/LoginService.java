package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginRequest;
import com.nuobao.bussiness.integration.response.LoginResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 会员登录接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:20
 * @modify
 **/
@Component
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送会员登录
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public LoginResponse execute(LoginRequest request) throws Exception {
        logger.info("LoginRequestService.execute: request:{}", request);

        LoginResponse response = HttpUtil.callHostServerByPost(false, null, "UTF-8", request, LoginResponse.class);

        return response;
    }
}
