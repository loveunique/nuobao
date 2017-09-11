package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 创建登录接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-06 九月 23:53
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest extends BaseRequest {

    private LoginRequestInput input;

    public LoginRequest() {
        super();
    }

    public LoginRequest(String organId, String channel) {
        super(organId, channel);
    }

    public LoginRequestInput getInput() {
        return input;
    }

    public void setInput(LoginRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "input=" + input +
                '}';
    }
}
