package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员注册响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:07
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberRegisterResponse extends BaseResponse {

    private static final long serialVersionUID = -4995191374237261073L;

    //客户号
    @JSONField(name="cust_no")
    private String custNo;

    public MemberRegisterResponse() {
        super();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    @Override
    public String toString() {
        return "MemberRegisterResponse{" +
                "custNo='" + custNo + '\'' +
                '}';
    }
}
