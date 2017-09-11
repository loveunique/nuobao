package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺商认证信息查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantInfoQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -9129756267543948422L;

    private MerchantInfoQueryRequestInput input;

    public MerchantInfoQueryRequest() {
        super();
    }

    public MerchantInfoQueryRequest(String organId, String channel) {
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
