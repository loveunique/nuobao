package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 登录密码重置
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginPasswordResetRequest extends BaseRequest{

    private static final long serialVersionUID = 2879073341809235741L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //登录密码 256 M
    @JSONField(name="logon_pwd")
    private String logonPwd;

    public LoginPasswordResetRequest() {
        super();
    }

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
        return "LoginPasswordResetRequest{" +
                "custNo='" + custNo + '\'' +
                ", logonPwd='" + logonPwd + '\'' +
                '}';
    }
}
