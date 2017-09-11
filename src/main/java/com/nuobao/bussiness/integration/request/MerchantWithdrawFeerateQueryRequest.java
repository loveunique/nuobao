package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现税率查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawFeerateQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 4543572742089715341L;

    private MerchantWithdrawFeerateQueryRequestInput input;

    public MerchantWithdrawFeerateQueryRequest() {
        super();
    }

    public MerchantWithdrawFeerateQueryRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MerchantWithdrawFeerateQueryRequestInput getInput() {
        return input;
    }

    public void setInput(MerchantWithdrawFeerateQueryRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawFeerateQueryRequest{" +
                "input=" + input +
                '}';
    }
}
