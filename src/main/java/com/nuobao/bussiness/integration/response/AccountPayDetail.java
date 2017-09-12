package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 诺宝支付明细详情
 * 04=诺宝支付
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:18
 * @modify
 **/
public class AccountPayDetail extends TranDetail{

    private static final long serialVersionUID = 5453667990409602863L;

    //支付金额
    @JSONField(name="nb_pay_amount")
    private BigDecimal payAmount;

    //支付状态
    @JSONField(name="nb_pay_state")
    private String payState;

    //支付时间
    @JSONField(name="nb_pay_date", format = "yyyyMMddHHmmss")
    private Date payDate;

    //支付流水号
    @JSONField(name="nb_pay_flow_no")
    private String payFlowNo;

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
        return "AccountPayDetail{" +
                "payAmount=" + payAmount +
                ", payState='" + payState + '\'' +
                ", payDate=" + payDate +
                ", payFlowNo='" + payFlowNo + '\'' +
                '}';
    }
}
