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
public class MerchantChargeNotifyRequest extends BaseRequest {

    private static final long serialVersionUID = 1726628134056373467L;

    private MerchantInfoQueryRequestInput input;

    public MerchantChargeNotifyRequest() {
        super();
    }

    public MerchantChargeNotifyRequest(String organId, String channel) {
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
        return "MerchantChargeNotifyRequest{" +
                "input=" + input +
                '}';
    }
}
