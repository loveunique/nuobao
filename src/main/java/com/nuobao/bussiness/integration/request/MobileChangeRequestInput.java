package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 注册手机号码更换发送报文体
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:58
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileChangeRequestInput implements Serializable{
    
    private static final long serialVersionUID = -5971300361889996275L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //新手机号码 11 M
    @JSONField(name="mobile_no_new")
    private String mobileNoNew;

    //登录密码 256 M
    @JSONField(name="logon_pwd")
    private String logonPwd;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getMobileNoNew() {
        return mobileNoNew;
    }

    public void setMobileNoNew(String mobileNoNew) {
        this.mobileNoNew = mobileNoNew;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    @Override
    public String toString() {
        return "MobileChangeRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", mobileNoNew='" + mobileNoNew + '\'' +
                ", logonPwd='" + logonPwd + '\'' +
                '}';
    }
}
