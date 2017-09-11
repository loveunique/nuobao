package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员信息更新
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:09
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberInfoModifyRequest extends BaseRequest {

    private static final long serialVersionUID = 4952523065222715459L;

    private MemberRegisterRequestInput input;

    public MemberInfoModifyRequest() {
        super();
    }

    public MemberInfoModifyRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MemberRegisterRequestInput getInput() {
        return input;
    }

    public void setInput(MemberRegisterRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MemberInfoModifyRequest{" +
                "input=" + input +
                '}';
    }
}
