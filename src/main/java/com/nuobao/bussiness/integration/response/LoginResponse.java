package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 创建登录返回信息
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 0:25
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse extends BaseResponse{

    private static final long serialVersionUID = 4884393687070129272L;

    private LoginResponseOut responseOut;

    public LoginResponse() {
        super();
    }

    public LoginResponseOut getResponseOut() {
        return responseOut;
    }

    public void setResponseOut(LoginResponseOut responseOut) {
        this.responseOut = responseOut;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "responseOut=" + responseOut +
                '}';
    }
}
