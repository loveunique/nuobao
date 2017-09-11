package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 诺宝往来伙伴查询返回报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:40
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantPartnerQueryResponseOut implements Serializable {

    private static final long serialVersionUID = 3243445705017166018L;

    //卡号列表
    @JSONField(name="partner_list")
    private List<PartnerInfo> partnerInfos = new ArrayList<PartnerInfo>();

    public List<PartnerInfo> getPartnerInfos() {
        return partnerInfos;
    }

    public void setPartnerInfos(List<PartnerInfo> partnerInfos) {
        this.partnerInfos = partnerInfos;
    }

    @Override
    public String toString() {
        return "MerchantPartnerQueryResponseOut{" +
                "partnerInfos=" + partnerInfos +
                '}';
    }
}
