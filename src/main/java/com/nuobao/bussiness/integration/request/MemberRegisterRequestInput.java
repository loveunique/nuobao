package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 会员注册发送报文体
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:02
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberRegisterRequestInput implements Serializable{

    private static final long serialVersionUID = 2878666402010513579L;

    //手机号码 11 M
    @JSONField(name="mobile_no")
    private String mobileNo;

    //推荐人手机号 11 M
    @JSONField(name="recmd_mobile_no")
    private String recommdMobileNo;

    //登录密码 256 M
    @JSONField(name="logon_pwd")
    private String logonPwd;

    //登录密码 256 M
    @JSONField(name="tran_pwd")
    private String tranPwd;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRecommdMobileNo() {
        return recommdMobileNo;
    }

    public void setRecommdMobileNo(String recommdMobileNo) {
        this.recommdMobileNo = recommdMobileNo;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    public String getTranPwd() {
        return tranPwd;
    }

    public void setTranPwd(String tranPwd) {
        this.tranPwd = tranPwd;
    }

    @Override
    public String toString() {
        return "MemberRegisterRequestInput{" +
                "mobileNo='" + mobileNo + '\'' +
                ", recommdMobileNo='" + recommdMobileNo + '\'' +
                ", logonPwd='" + logonPwd + '\'' +
                ", tranPwd='" + tranPwd + '\'' +
                '}';
    }
}
