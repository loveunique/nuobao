package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺宝提现银行卡查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWithdrawCardQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 4543572742089715341L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //开户行 10 O
    @JSONField(name="bank_type")
    private String bankType;

    public MerchantWithdrawCardQueryRequest() {
        super();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawCardQueryRequest{" +
                super.toString() +
                "custNo='" + custNo + '\'' +
                ", bankType='" + bankType + '\'' +
                '}';
    }
}
