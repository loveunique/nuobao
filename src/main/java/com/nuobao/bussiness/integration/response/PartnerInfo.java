package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 往来伙伴信息
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 23:46
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerInfo implements Serializable {

    private static final long serialVersionUID = 5354350995530383015L;

    //客户号
    @JSONField(name="partner_cust_no")
    private String custNo;

    //手机号
    @JSONField(name="partner_mobile_no")
    private String mobileNo;

    //姓名
    @JSONField(name="partner_name")
    private String name;

    //诺宝账号
    @JSONField(name="partner_acc_no")
    private String accNo;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    @Override
    public String toString() {
        return "PartnerInfo{" +
                "custNo='" + custNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", name='" + name + '\'' +
                ", accNo='" + accNo + '\'' +
                '}';
    }
}
