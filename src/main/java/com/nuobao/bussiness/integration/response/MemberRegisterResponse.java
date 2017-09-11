package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员注册响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:07
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberRegisterResponse extends BaseResponse {

    private static final long serialVersionUID = -4995191374237261073L;

    private MemberRegisterResponseOut out;

    public MemberRegisterResponse() {
        super();
    }

    public MemberRegisterResponseOut getOut() {
        return out;
    }

    public void setOut(MemberRegisterResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MemberRegisterResponse{" +
                "out=" + out +
                '}';
    }
}
