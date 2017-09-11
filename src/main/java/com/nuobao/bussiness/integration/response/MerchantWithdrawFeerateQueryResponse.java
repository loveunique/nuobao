package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现税率查询响应结果
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:39
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawFeerateQueryResponse extends BaseResponse {

    private static final long serialVersionUID = -1221843736869470118L;

    private MerchantWithdrawFeerateQueryResponseOut out;

    public MerchantWithdrawFeerateQueryResponse() {
        super();
    }

    public MerchantWithdrawFeerateQueryResponseOut getOut() {
        return out;
    }

    public void setOut(MerchantWithdrawFeerateQueryResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawFeerateQueryResponse{" +
                "out=" + out +
                '}';
    }
}
