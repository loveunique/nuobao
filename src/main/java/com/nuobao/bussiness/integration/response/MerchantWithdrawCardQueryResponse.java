package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 诺宝提现银行卡查询响应结果
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:39
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawCardQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 8951396286625152846L;

    //卡号列表
    @JSONField(name="card_list")
    private List<CardInfo> cardInfoList = new ArrayList<CardInfo>();

    public MerchantWithdrawCardQueryResponse() {
        super();
    }

    public List<CardInfo> getCardInfoList() {
        return cardInfoList;
    }

    public void setCardInfoList(List<CardInfo> cardInfoList) {
        this.cardInfoList = cardInfoList;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawCardQueryResponse{" +
                "cardInfoList=" + cardInfoList +
                '}';
    }
}
