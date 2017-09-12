package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 诺宝积分转换明细详情
 * 03=积分转换
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:18
 * @modify
 **/
public class AccountScoreChangeDetail extends TranDetail{

    private static final long serialVersionUID = -6926153595999376476L;

    //转换比例
    @JSONField(name="convert_rate")
    private int convertRate;

    //转换基数
    @JSONField(name="convert_base")
    private BigDecimal convertBase;

    //转换时间
    @JSONField(name="convert_date", format = "yyyyMMddHHmmss")
    private Date convertDate;

    //转换状态
    @JSONField(name="convert_state")
    private String convertState;

    //转换流水号
    @JSONField(name="convert_flow_no")
    private String convertFlowNo;

    public int getConvertRate() {
        return convertRate;
    }

    public void setConvertRate(int convertRate) {
        this.convertRate = convertRate;
    }

    public BigDecimal getConvertBase() {
        return convertBase;
    }

    public void setConvertBase(BigDecimal convertBase) {
        this.convertBase = convertBase;
    }

    public Date getConvertDate() {
        return convertDate;
    }

    public void setConvertDate(Date convertDate) {
        this.convertDate = convertDate;
    }

    public String getConvertState() {
        return convertState;
    }

    public void setConvertState(String convertState) {
        this.convertState = convertState;
    }

    public String getConvertFlowNo() {
        return convertFlowNo;
    }

    public void setConvertFlowNo(String convertFlowNo) {
        this.convertFlowNo = convertFlowNo;
    }

    @Override
    public String toString() {
        return "AccountScoreChangeDetail{" +
                "convertRate=" + convertRate +
                ", convertBase=" + convertBase +
                ", convertDate=" + convertDate +
                ", convertState='" + convertState + '\'' +
                ", convertFlowNo='" + convertFlowNo + '\'' +
                '}';
    }
}
