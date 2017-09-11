package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现银行卡查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawCardQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 4543572742089715341L;

    private MerchantWithdrawCardQueryRequestInput input;

    public MerchantWithdrawCardQueryRequest() {
        super();
    }

    public MerchantWithdrawCardQueryRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MerchantWithdrawCardQueryRequestInput getInput() {
        return input;
    }

    public void setInput(MerchantWithdrawCardQueryRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawCardQueryRequest{" +
                "input=" + input +
                '}';
    }
}
