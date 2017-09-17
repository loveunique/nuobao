package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

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

    //税率
    @JSONField(name="fee_rate")
    private BigDecimal feeRate = BigDecimal.ZERO;

    public MerchantWithdrawFeerateQueryResponse() {
        super();
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawFeerateQueryResponse{" +
                "feeRate=" + feeRate +
                '}';
    }
}
