package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 诺宝转账明细详情
 * 02=诺宝转账
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:17
 * @modify
 **/
public class AccountTransferDetail extends TranDetail{

    private static final long serialVersionUID = -6744529174923357610L;

    //对方账号
    @JSONField(name="tran_acc_no")
    private String recvAccNo;

    //对方户名
    @JSONField(name="tran_name")
    private String recvAccName;

    //转账时间
    @JSONField(name="tran_date", format = "yyyyMMddHHmmss")
    private Date tranDate;

    //转账状态
    @JSONField(name="tran_state")
    private String tranState;

    //转账流水号
    @JSONField(name="tran_flow_no")
    private String tranFlowNo;

    public String getRecvAccNo() {
        return recvAccNo;
    }

    public void setRecvAccNo(String recvAccNo) {
        this.recvAccNo = recvAccNo;
    }

    public String getRecvAccName() {
        return recvAccName;
    }

    public void setRecvAccName(String recvAccName) {
        this.recvAccName = recvAccName;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranState() {
        return tranState;
    }

    public void setTranState(String tranState) {
        this.tranState = tranState;
    }

    public String getTranFlowNo() {
        return tranFlowNo;
    }

    public void setTranFlowNo(String tranFlowNo) {
        this.tranFlowNo = tranFlowNo;
    }

    @Override
    public String toString() {
        return "AccountTransferDetail{" +
                "recvAccNo='" + recvAccNo + '\'' +
                ", recvAccName='" + recvAccName + '\'' +
                ", tranDate=" + tranDate +
                ", tranState='" + tranState + '\'' +
                ", tranFlowNo='" + tranFlowNo + '\'' +
                '}';
    }
}
