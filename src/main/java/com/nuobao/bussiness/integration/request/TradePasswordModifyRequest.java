package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员交易密码修改
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePasswordModifyRequest extends BaseRequest{

    private static final long serialVersionUID = 5557457685679403090L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //原登录密码 256 M
    @JSONField(name="tran_pwd_old")
    private String tranPwdOld;

    //新登录密码 256 M
    @JSONField(name="tran_pwd_new")
    private String tranPwdNew;

    public TradePasswordModifyRequest() {
        super();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getTranPwdOld() {
        return tranPwdOld;
    }

    public void setTranPwdOld(String tranPwdOld) {
        this.tranPwdOld = tranPwdOld;
    }

    public String getTranPwdNew() {
        return tranPwdNew;
    }

    public void setTranPwdNew(String tranPwdNew) {
        this.tranPwdNew = tranPwdNew;
    }

    @Override
    public String toString() {
        return "TradePasswordModifyRequest{" +
                "custNo='" + custNo + '\'' +
                ", tranPwdOld='" + tranPwdOld + '\'' +
                ", tranPwdNew='" + tranPwdNew + '\'' +
                '}';
    }
}
