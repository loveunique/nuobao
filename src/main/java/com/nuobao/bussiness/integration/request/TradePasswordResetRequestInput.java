package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 会员交易密码重置发送报文体
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:48
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePasswordResetRequestInput implements Serializable{

    private static final long serialVersionUID = 3534425823558156499L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //登录密码 256 M
    @JSONField(name="tran_pwd")
    private String tranPwd;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getTranPwd() {
        return tranPwd;
    }

    public void setTranPwd(String tranPwd) {
        this.tranPwd = tranPwd;
    }

    @Override
    public String toString() {
        return "TradePasswordResetRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", tranPwd='" + tranPwd + '\'' +
                '}';
    }
}
