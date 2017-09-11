package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝充值支付响应结果
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:39
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantChargeResponse extends BaseResponse {

    private static final long serialVersionUID = 8951396286625152846L;

    private MerchantChargeResponseOut out;

    public MerchantChargeResponse() {
        super();
    }

    public MerchantChargeResponseOut getOut() {
        return out;
    }

    public void setOut(MerchantChargeResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MerchantChargeResponse{" +
                "out=" + out +
                '}';
    }
}
