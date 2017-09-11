package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 登录密码修改发送报文体
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:48
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginPasswordModifyRequestInput implements Serializable{

    private static final long serialVersionUID = 3552625485644830239L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //原登录密码 256 M
    @JSONField(name="logon_pwd_old")
    private String logonPwdOld;

    //新登录密码 256 M
    @JSONField(name="logon_pwd_new")
    private String logonPwdNew;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getLogonPwdOld() {
        return logonPwdOld;
    }

    public void setLogonPwdOld(String logonPwdOld) {
        this.logonPwdOld = logonPwdOld;
    }

    public String getLogonPwdNew() {
        return logonPwdNew;
    }

    public void setLogonPwdNew(String logonPwdNew) {
        this.logonPwdNew = logonPwdNew;
    }

    @Override
    public String toString() {
        return "LoginPasswordModifyRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", logonPwdOld='" + logonPwdOld + '\'' +
                ", logonPwdNew='" + logonPwdNew + '\'' +
                '}';
    }
}
