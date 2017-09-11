package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 会员注册响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:07
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberRegisterResponseOut implements Serializable {

    private static final long serialVersionUID = -919273285348484629L;

    //客户号
    @JSONField(name="cust_no")
    private String custNo;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    @Override
    public String toString() {
        return "MemberRegisterResponseOut{" +
                "custNo='" + custNo + '\'' +
                '}';
    }
}
