package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 创建登录接口内容类
 *
 * @author Xu Chengzhi
 * @date 2017-09-06 九月 23:53
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequestInput implements Serializable {

    private static final long serialVersionUID = 6795944373956369642L;

    //手机号码 11 M
    @JSONField(name="mobile_no")
    private String mobileNo;

    //登录密码 256 M
    @JSONField(name="logon_pwd")
    private String logonPwd;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    @Override
    public String toString() {
        return "LoginRequestInput{" +
                "mobileNo='" + mobileNo + '\'' +
                ", logonPwd='" + logonPwd + '\'' +
                '}';
    }
}
