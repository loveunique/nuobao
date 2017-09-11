package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员注册
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:02
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberRegisterRequest extends BaseRequest {

    private static final long serialVersionUID = -6700648578562940420L;

    public MemberRegisterRequest() {
        super();
    }

    public MemberRegisterRequest(String organId, String channel) {
        super(organId, channel);
    }

    private MemberRegisterRequestInput input;

    public MemberRegisterRequestInput getInput() {
        return input;
    }

    public void setInput(MemberRegisterRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MemberRegisterRequest{" +
                "input=" + input +
                '}';
    }
}
