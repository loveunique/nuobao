package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
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

    //预支付订单号
    @JSONField(name="prepay_id")
    private String prepayId;

    public MerchantChargeResponse() {
        super();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    @Override
    public String toString() {
        return "MerchantChargeResponse{" +
                "prepayId='" + prepayId + '\'' +
                '}';
    }
}
