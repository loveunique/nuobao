package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 登录密码修改
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginPasswordModifyRequest extends BaseRequest{

    private static final long serialVersionUID = 1921455879960533698L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //原登录密码 256 M
    @JSONField(name="logon_pwd_old")
    private String logonPwdOld;

    //新登录密码 256 M
    @JSONField(name="logon_pwd_new")
    private String logonPwdNew;

    public LoginPasswordModifyRequest() {
        super();
    }

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
        return "LoginPasswordModifyRequest{" +
                super.toString() +
                "custNo='" + custNo + '\'' +
                ", logonPwdOld='" + logonPwdOld + '\'' +
                ", logonPwdNew='" + logonPwdNew + '\'' +
                '}';
    }
}
