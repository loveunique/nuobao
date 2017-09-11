package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺星会员开通支付结果通知
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:09
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPreparePayNotifyRequest extends BaseRequest {

    private static final long serialVersionUID = 6667544418051706003L;

    private MemberPreparePayNotifyRequestInput input;

    public MemberPreparePayNotifyRequest() {
        super();
    }

    public MemberPreparePayNotifyRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MemberPreparePayNotifyRequestInput getInput() {
        return input;
    }

    public void setInput(MemberPreparePayNotifyRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MemberPreparePayNotifyRequest{" +
                "input=" + input +
                '}';
    }
}
