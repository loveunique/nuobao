package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 诺宝充值明细详情
 * 00=诺宝充值
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:16
 * @modify
 **/
public class AccountChargeDetail extends TranDetail{

    private static final long serialVersionUID = 5071095039954614053L;

    //支付方式
    @JSONField(name="pay_type_desc")
    private String payTypeDesc;

    //支付金额
    @JSONField(name="pay_amount")
    private BigDecimal payAmount;

    //支付状态
    @JSONField(name="pay_state")
    private String payState;

    //支付时间
    @JSONField(name="pay_date", format = "yyyyMMddHHmmss")
    private Date payDate;

    //交易流水号
    @JSONField(name="pay_flow_no")
    private String payFlowNo;

    public String getPayTypeDesc() {
        return payTypeDesc;
    }

    public void setPayTypeDesc(String payTypeDesc) {
        this.payTypeDesc = payTypeDesc;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPayFlowNo() {
        return payFlowNo;
    }

    public void setPayFlowNo(String payFlowNo) {
        this.payFlowNo = payFlowNo;
    }

    @Override
    public String toString() {
        return "AccountChargeDetail{" +
                "payTypeDesc='" + payTypeDesc + '\'' +
                ", payAmount=" + payAmount +
                ", payState='" + payState + '\'' +
                ", payDate=" + payDate +
                ", payFlowNo='" + payFlowNo + '\'' +
                '}';
    }
}
