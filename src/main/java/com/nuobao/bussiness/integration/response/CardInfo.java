package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 银行卡信息
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 23:46
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardInfo implements Serializable {

    private static final long serialVersionUID = -3331645914358734880L;

    //卡号
    @JSONField(name="card_no")
    private String cardNo;

    //联行号
    @JSONField(name="bank_no")
    private String bankNo;

    //银行类别
    @JSONField(name="bank_type")
    private String bankType;

    //银行卡户名
    @JSONField(name="card_name")
    private String cardName;

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

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "cardNo='" + cardNo + '\'' +
                ", bankNo='" + bankNo + '\'' +
                ", bankType='" + bankType + '\'' +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
