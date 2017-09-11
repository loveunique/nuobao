package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 诺宝提现银行卡查询返回报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:40
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawCardQueryResponseOut implements Serializable {

    private static final long serialVersionUID = 3243445705017166018L;

    //卡号列表
    @JSONField(name="card_list")
    private List<CardInfo> cardInfoList = new ArrayList<CardInfo>();

    public List<CardInfo> getCardInfoList() {
        return cardInfoList;
    }

    public void setCardInfoList(List<CardInfo> cardInfoList) {
        this.cardInfoList = cardInfoList;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawCardQueryResponseOut{" +
                "cardInfoList=" + cardInfoList +
                '}';
    }
}
