package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝往来伙伴查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantPartnerQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -3893672733054419794L;

    private MerchantPartnerQueryRequestInput input;

    public MerchantPartnerQueryRequest() {
        super();
    }

    public MerchantPartnerQueryRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MerchantPartnerQueryRequestInput getInput() {
        return input;
    }

    public void setInput(MerchantPartnerQueryRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MerchantPartnerQueryRequestInput{" +
                "input=" + input +
                '}';
    }
}
