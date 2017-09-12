package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 诺宝提现明细详情
 * 01=诺宝提现
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:17
 * @modify
 **/
public class AccountWithdrawDetail extends TranDetail{

    private static final long serialVersionUID = -1715604590538488210L;

    //提现金额
    @JSONField(name="withdraw_amount")
    private BigDecimal withdrawAmount;

    //提现税率%
    @JSONField(name="fee_rate")
    private int feeRate;

    //提现税费
    @JSONField(name="fee")
    private BigDecimal fee;

    //实到金额
    @JSONField(name="actual_amount")
    private BigDecimal actualAmount;

    //入账银行
    @JSONField(name="in_bank")
    private String inBank;

    //入账户名
    @JSONField(name="in_name")
    private String inAccName;

    //入账卡号
    @JSONField(name="in_card")
    private String inCard;

    //入账金额
    @JSONField(name="in_amount")
    private BigDecimal inAmount;

    //申请时间
    @JSONField(name="apply_date")
    private Date applyDate;

    //提现状态
    @JSONField(name="withdraw_state")
    private String withdrawState;

    //交易流水号
    @JSONField(name="withdraw_flow_no")
    private String withdrawFlowNo;

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public int getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(int feeRate) {
        this.feeRate = feeRate;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getInBank() {
        return inBank;
    }

    public void setInBank(String inBank) {
        this.inBank = inBank;
    }

    public String getInAccName() {
        return inAccName;
    }

    public void setInAccName(String inAccName) {
        this.inAccName = inAccName;
    }

    public String getInCard() {
        return inCard;
    }

    public void setInCard(String inCard) {
        this.inCard = inCard;
    }

    public BigDecimal getInAmount() {
        return inAmount;
    }

    public void setInAmount(BigDecimal inAmount) {
        this.inAmount = inAmount;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getWithdrawState() {
        return withdrawState;
    }

    public void setWithdrawState(String withdrawState) {
        this.withdrawState = withdrawState;
    }

    public String getWithdrawFlowNo() {
        return withdrawFlowNo;
    }

    public void setWithdrawFlowNo(String withdrawFlowNo) {
        this.withdrawFlowNo = withdrawFlowNo;
    }

    @Override
    public String toString() {
        return "AccountWithdrawDetail{" +
                "withdrawAmount=" + withdrawAmount +
                ", feeRate=" + feeRate +
                ", fee=" + fee +
                ", actualAmount=" + actualAmount +
                ", inBank='" + inBank + '\'' +
                ", inAccName='" + inAccName + '\'' +
                ", inCard='" + inCard + '\'' +
                ", inAmount=" + inAmount +
                ", applyDate=" + applyDate +
                ", withdrawState='" + withdrawState + '\'' +
                ", withdrawFlowNo='" + withdrawFlowNo + '\'' +
                '}';
    }
}
