package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 普通会员开通为诺星会员支付订单
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:09
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPreparePayRequest extends BaseRequest {

    private static final long serialVersionUID = -395173136578131944L;

    private MemberPreparePayRequestInput input;

    public MemberPreparePayRequest() {
        super();
    }

    public MemberPreparePayRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MemberPreparePayRequestInput getInput() {
        return input;
    }

    public void setInput(MemberPreparePayRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MemberPreparePayRequest{" +
                "input=" + input +
                '}';
    }
}
