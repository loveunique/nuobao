package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现申请
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawRequest extends BaseRequest {

    private static final long serialVersionUID = 6811305761088001647L;

    private MerchantWithdrawRequestInput input;

    public MerchantWithdrawRequest() {
        super();
    }

    public MerchantWithdrawRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MerchantWithdrawRequestInput getInput() {
        return input;
    }

    public void setInput(MerchantWithdrawRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawRequest{" +
                "input=" + input +
                '}';
    }
}
