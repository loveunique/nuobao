package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * 诺星会员开通支付结果通知
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:09
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPreparePayNotifyRequest extends BaseRequest {

    private static final long serialVersionUID = 6667544418051706003L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //平台服务费 18,2 M
    @JSONField(name="pay_amount")
    private BigDecimal payAmount = BigDecimal.ZERO;

    //充值方式 2 M  00=微  信 01=支付宝
    @JSONField(name="pay_type")
    private String payType;

    //预支付订单号 32 M
    @JSONField(name="prepay_id")
    private String prepayId;

    //微信、支付宝平台订单号 32 M 退款使用
    @JSONField(name="pay_id")
    private String payId;

    //支付结果 2 M 0=成  功 1=失  败 2=待支付
    @JSONField(name="pay_result")
    private String payResult;

    //类型 2 M 00=诺星
    @JSONField(name="biz_type")
    private String bizType = "00";

    public MemberPreparePayNotifyRequest() {
        super();
    }

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

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @Override
    public String toString() {
        return "MemberPreparePayNotifyRequest{" +
                "custNo='" + custNo + '\'' +
                ", payAmount=" + payAmount +
                ", payType='" + payType + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", payId='" + payId + '\'' +
                ", payResult='" + payResult + '\'' +
                ", bizType='" + bizType + '\'' +
                '}';
    }
}
