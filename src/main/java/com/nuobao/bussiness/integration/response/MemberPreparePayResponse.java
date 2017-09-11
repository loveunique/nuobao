package com.nuobao.bussiness.integration.response;

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

    private MemberPreparePayResponseOut out;

    public MemberPreparePayResponse() {
        super();
    }

    public MemberPreparePayResponseOut getOut() {
        return out;
    }

    public void setOut(MemberPreparePayResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MemberPreparePayResponse{" +
                "out=" + out +
                '}';
    }
}
