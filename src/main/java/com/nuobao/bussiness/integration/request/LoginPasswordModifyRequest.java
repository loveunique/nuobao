package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 登录密码修改
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginPasswordModifyRequest extends BaseRequest{

    private static final long serialVersionUID = 1921455879960533698L;

    private LoginPasswordModifyRequestInput input;

    public LoginPasswordModifyRequest() {
        super();
    }

    public LoginPasswordModifyRequest(String organId, String channel) {
        super(organId, channel);
    }

    public LoginPasswordModifyRequestInput getInput() {
        return input;
    }

    public void setInput(LoginPasswordModifyRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "LoginPasswordModifyRequest{" +
                "input=" + input +
                '}';
    }
}
