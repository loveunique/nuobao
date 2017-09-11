package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 登录密码重置发送报文体
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:48
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginPasswordResetRequestInput implements Serializable{

    private static final long serialVersionUID = 6244174275886491187L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //登录密码 256 M
    @JSONField(name="logon_pwd")
    private String logonPwd;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    @Override
    public String toString() {
        return "LoginPasswordResetRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", logonPwd='" + logonPwd + '\'' +
                '}';
    }
}
