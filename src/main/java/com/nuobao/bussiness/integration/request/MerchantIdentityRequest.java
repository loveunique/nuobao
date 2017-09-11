package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺商认证
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantIdentityRequest extends BaseRequest {

    private static final long serialVersionUID = -9129756267543948422L;

    private MerchantIdentityRequestInput input;

    public MerchantIdentityRequest() {
        super();
    }

    public MerchantIdentityRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MerchantIdentityRequestInput getInput() {
        return input;
    }

    public void setInput(MerchantIdentityRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MerchantIdentityRequest{" +
                "input=" + input +
                '}';
    }
}
