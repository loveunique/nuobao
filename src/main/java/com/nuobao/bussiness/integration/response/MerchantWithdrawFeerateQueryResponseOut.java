package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 诺宝提现税率查询返回报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:40
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawFeerateQueryResponseOut implements Serializable {

    private static final long serialVersionUID = 3243445705017166018L;

    //税率
    @JSONField(name="fee_rate")
    private BigDecimal feeRate = BigDecimal.ZERO;

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawFeerateQueryResponseOut{" +
                "feeRate=" + feeRate +
                '}';
    }
}
