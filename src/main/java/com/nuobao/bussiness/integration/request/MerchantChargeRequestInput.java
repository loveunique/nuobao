package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 诺宝充值支付
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantChargeRequestInput extends BaseRequest {

    private static final long serialVersionUID = -1540819416700946771L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //平台服务费 18,2 M
    @JSONField(name="pay_amount")
    private BigDecimal payAmount = BigDecimal.ZERO;

    //充值方式 2 M  00=微  信 01=支付宝
    @JSONField(name="pay_type")
    private String payType;

    //类型 2 M 00=诺星
    @JSONField(name="biz_type")
    private String bizType = "00";

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @Override
    public String toString() {
        return "MerchantChargeRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", payAmount=" + payAmount +
                ", payType='" + payType + '\'' +
                ", bizType='" + bizType + '\'' +
                '}';
    }
}
