package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

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

    //卡号列表
    @JSONField(name="partner_list")
    private List<PartnerInfo> partnerInfos = new ArrayList<PartnerInfo>();

    public MerchantPartnerQueryResponse() {
        super();
    }

    public List<PartnerInfo> getPartnerInfos() {
        return partnerInfos;
    }

    public void setPartnerInfos(List<PartnerInfo> partnerInfos) {
        this.partnerInfos = partnerInfos;
    }

    @Override
    public String toString() {
        return "MerchantPartnerQueryResponse{" +
                "partnerInfos=" + partnerInfos +
                '}';
    }
}
