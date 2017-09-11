package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * 诺宝提现申请
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawRequestInput extends BaseRequest {

    private static final long serialVersionUID = 302715644890986086L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //类型 2 M 00=诺星
    @JSONField(name="biz_type")
    private String bizType = "00";

    //平台服务费 18,2 M
    @JSONField(name="withdraw_amount")
    private BigDecimal withdrawAmount = BigDecimal.ZERO;

    //银行卡号 32 M
    @JSONField(name="card_no")
    private String cardNo;

    //银行卡开户行联行号 32 M
    @JSONField(name="bank_no")
    private String bankNo;

    //交易密码 256 M
    @JSONField(name="tran_pwd")
    private String tranPwd;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getTranPwd() {
        return tranPwd;
    }

    public void setTranPwd(String tranPwd) {
        this.tranPwd = tranPwd;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", bizType='" + bizType + '\'' +
                ", withdrawAmount=" + withdrawAmount +
                ", cardNo='" + cardNo + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", tranPwd='" + tranPwd + '\'' +
                '}';
    }
}
