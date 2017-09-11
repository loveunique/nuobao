package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现银行卡查询响应结果
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:39
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawCardQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 8951396286625152846L;

    private MerchantWithdrawCardQueryResponseOut out;

    public MerchantWithdrawCardQueryResponse() {
        super();
    }

    public MerchantWithdrawCardQueryResponseOut getOut() {
        return out;
    }

    public void setOut(MerchantWithdrawCardQueryResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawCardQueryResponse{" +
                "out=" + out +
                '}';
    }
}
