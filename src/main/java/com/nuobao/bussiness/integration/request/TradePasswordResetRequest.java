package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员交易密码重置
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePasswordResetRequest extends BaseRequest{

    private static final long serialVersionUID = 9199166669325925447L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //登录密码 256 M
    @JSONField(name="tran_pwd")
    private String tranPwd;

    public TradePasswordResetRequest() {
        super();
    }

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
        return "TradePasswordResetRequest{" +
                "custNo='" + custNo + '\'' +
                ", tranPwd='" + tranPwd + '\'' +
                '}';
    }
}
