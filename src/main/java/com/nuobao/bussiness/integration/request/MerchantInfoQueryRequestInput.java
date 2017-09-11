package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺商认证信息查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantInfoQueryRequestInput extends BaseRequest {

    private static final long serialVersionUID = -8236631851014908964L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    @Override
    public String toString() {
        return "MerchantIdentityRequest{" +
                "custNo='" + custNo + '\'' +
                '}';
    }
}
