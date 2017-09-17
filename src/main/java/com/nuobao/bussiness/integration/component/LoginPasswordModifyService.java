package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.LoginPasswordModifyRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建登录密码修改Service
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:12
 * @modify
 **/
@Component
public class LoginPasswordModifyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送密码修改
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public BaseResponse execute(LoginPasswordModifyRequest request) throws Exception {
        logger.info("LoginPasswordModifyService.execute: request:{}", request);

        BaseResponse response = HttpUtil.callHostServerByPost(true, "/vm/a.txt", "UTF-8", request, BaseResponse.class);

        return response;
    }
}
