package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 诺宝账户之间转账
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 21:48
 * @modify
 **/
public class TransferRequest extends BaseRequest{

    private static final long serialVersionUID = -8610286788788871203L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //类型 2 M 00=诺宝
    @JSONField(name="biz_type")
    private String bizType = "00";

    //转账金额 18,2 M
    @JSONField(name="tran_amount")
    private BigDecimal tranAmount = BigDecimal.ZERO;

    //收款诺宝账户 32 M
    @JSONField(name="recv_acc_no")
    private String recvAccNo;

    //收款方客户号 32 O
    @JSONField(name="recv_cust_no")
    private String recvCustNo;

    //收款人姓名 64 M
    @JSONField(name="recv_cust_name")
    private String recvCustName;

    //交易密码 256 M
    @JSONField(name="tran_pwd")
    private String tranPwd;

    //转账时间 14 M
    @JSONField(name="recv_cust_no", format = "yyyyMMddHHmmss")
    private Date tranDate = new Date();

    public TransferRequest() {
        super();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    public String getRecvAccNo() {
        return recvAccNo;
    }

    public void setRecvAccNo(String recvAccNo) {
        this.recvAccNo = recvAccNo;
    }

    public String getRecvCustNo() {
        return recvCustNo;
    }

    public void setRecvCustNo(String recvCustNo) {
        this.recvCustNo = recvCustNo;
    }

    public String getRecvCustName() {
        return recvCustName;
    }

    public void setRecvCustName(String recvCustName) {
        this.recvCustName = recvCustName;
    }

    public String getTranPwd() {
        return tranPwd;
    }

    public void setTranPwd(String tranPwd) {
        this.tranPwd = tranPwd;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                super.toString() +
                "custNo='" + custNo + '\'' +
                ", bizType='" + bizType + '\'' +
                ", tranAmount=" + tranAmount +
                ", recvAccNo='" + recvAccNo + '\'' +
                ", recvCustNo='" + recvCustNo + '\'' +
                ", recvCustName='" + recvCustName + '\'' +
                ", tranPwd='" + tranPwd + '\'' +
                ", tranDate=" + tranDate +
                '}';
    }
}
