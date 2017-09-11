package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 登录密码重置
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginPasswordResetRequest extends BaseRequest{

    private static final long serialVersionUID = 2879073341809235741L;

    private LoginPasswordResetRequestInput input;

    public LoginPasswordResetRequest() {
        super();
    }

    public LoginPasswordResetRequest(String organId, String channel) {
        super(organId, channel);
    }

    public LoginPasswordResetRequestInput getInput() {
        return input;
    }

    public void setInput(LoginPasswordResetRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "LoginPasswordResetRequest{" +
                "input=" + input +
                '}';
    }
}
