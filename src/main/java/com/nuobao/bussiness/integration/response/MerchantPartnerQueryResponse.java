package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝往来伙伴查询响应结果
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:39
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantPartnerQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 8951396286625152846L;

    private MerchantPartnerQueryResponseOut out;

    public MerchantPartnerQueryResponse() {
        super();
    }

    public MerchantPartnerQueryResponseOut getOut() {
        return out;
    }

    public void setOut(MerchantPartnerQueryResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MerchantPartnerQueryResponse{" +
                "out=" + out +
                '}';
    }
}
