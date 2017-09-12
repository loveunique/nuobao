package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 诺宝交易明细
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:15
 * @modify
 **/
public class TranDetail implements Serializable {

    private static final long serialVersionUID = 5997074222594356742L;

    //交易类型
    @JSONField(name="tran_type")
    private String tranType;

    //00=诺宝充值
    private AccountChargeDetail chargeDetail;

    //04=诺宝支付
    private AccountPayDetail payDetail;

    //03=积分转换
    private AccountScoreChangeDetail scoreChangeDetail;

    //02=诺宝转账
    private AccountTransferDetail transferDetail;

    //01=诺宝提现
    private AccountWithdrawDetail withdrawDetail;

    public TranDetail getDetail() {
        if(this.getTranType().equals("00")) {
            return chargeDetail;
        } else if(this.getTranType().equals("01")) {
            return withdrawDetail;
        } else if(this.getTranType().equals("02")) {
            return transferDetail;
        } else if(this.getTranType().equals("03")) {
            return scoreChangeDetail;
        } else if(this.getTranType().equals("04")) {
            return payDetail;
        } else {
            return null;
        }
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public AccountChargeDetail getChargeDetail() {
        return chargeDetail;
    }

    public void setChargeDetail(AccountChargeDetail chargeDetail) {
        this.chargeDetail = chargeDetail;
    }

    public AccountPayDetail getPayDetail() {
        return payDetail;
    }

    public void setPayDetail(AccountPayDetail payDetail) {
        this.payDetail = payDetail;
    }

    public AccountScoreChangeDetail getScoreChangeDetail() {
        return scoreChangeDetail;
    }

    public void setScoreChangeDetail(AccountScoreChangeDetail scoreChangeDetail) {
        this.scoreChangeDetail = scoreChangeDetail;
    }

    public AccountTransferDetail getTransferDetail() {
        return transferDetail;
    }

    public void setTransferDetail(AccountTransferDetail transferDetail) {
        this.transferDetail = transferDetail;
    }

    public AccountWithdrawDetail getWithdrawDetail() {
        return withdrawDetail;
    }

    public void setWithdrawDetail(AccountWithdrawDetail withdrawDetail) {
        this.withdrawDetail = withdrawDetail;
    }

    @Override
    public String toString() {
        return "TranDetail{" +
                "chargeDetail=" + chargeDetail +
                ", payDetail=" + payDetail +
                ", scoreChangeDetail=" + scoreChangeDetail +
                ", transferDetail=" + transferDetail +
                ", withdrawDetail=" + withdrawDetail +
                '}';
    }
}
