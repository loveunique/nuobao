package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 普通会员开通为诺星会员支付订单响应结果
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:39
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPreparePayResponse extends BaseResponse {

    private static final long serialVersionUID = 8951396286625152846L;

    //预支付订单号
    @JSONField(name="prepay_id")
    private String prepayId;

    public MemberPreparePayResponse() {
        super();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    @Override
    public String toString() {
        return "MemberPreparePayResponse{" +
                "prepayId='" + prepayId + '\'' +
                '}';
    }
}
