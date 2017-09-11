package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝充值支付
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantChargeRequest extends BaseRequest {

    private static final long serialVersionUID = 1726628134056373467L;

    private MerchantInfoQueryRequestInput input;

    public MerchantChargeRequest() {
        super();
    }

    public MerchantChargeRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MerchantInfoQueryRequestInput getInput() {
        return input;
    }

    public void setInput(MerchantInfoQueryRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MerchantInfoQueryRequestInput{" +
                "input=" + input +
                '}';
    }
}
