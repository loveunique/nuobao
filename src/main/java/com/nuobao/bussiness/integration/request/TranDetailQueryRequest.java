package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 诺宝交易明细查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:05
 * @modify
 **/
public class TranDetailQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 5483823710493819898L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //类型 2 M 00=诺宝
    @JSONField(name="biz_type")
    private String bizType = "00";

    //开始日期 8 M
    @JSONField(name="begin_date", format = "yyyyMMdd")
    private Date beginDate;

    //结束日期 8 M
    @JSONField(name="end_date", format = "yyyyMMdd")
    private Date endDate;

    //每页显示记录数 10 M
    @JSONField(name="per_page_show")
    private int pageSize = 10;

    //起始位置 10 M
    @JSONField(name="begin_pos")
    private int beginPos = 0;

    public TranDetailQueryRequest() {
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(int beginPos) {
        this.beginPos = beginPos;
    }

    @Override
    public String toString() {
        return "TranDetailQueryRequest{" +
                super.toString() +
                "custNo='" + custNo + '\'' +
                ", bizType='" + bizType + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", pageSize=" + pageSize +
                ", beginPos=" + beginPos +
                '}';
    }
}
