package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现税率查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawFeerateQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 4543572742089715341L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //类型 2 M 00=诺星
    @JSONField(name="biz_type")
    private String bizType = "00";

    public MerchantWithdrawFeerateQueryRequest() {
        super();
    }

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

    @Override
    public String toString() {
        return "MerchantWithdrawFeerateQueryRequest{" +
                super.toString() +
                "custNo='" + custNo + '\'' +
                ", bizType='" + bizType + '\'' +
                '}';
    }
}
