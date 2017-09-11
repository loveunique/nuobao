package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 诺宝充值支付返回报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:40
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantChargeResponseOut implements Serializable {

    private static final long serialVersionUID = 3243445705017166018L;

    //预支付订单号
    @JSONField(name="prepay_id")
    private String prepayId;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    @Override
    public String toString() {
        return "MerchantChargeResponseOut{" +
                "prepayId='" + prepayId + '\'' +
                '}';
    }
}
