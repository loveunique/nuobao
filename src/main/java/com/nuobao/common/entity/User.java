package com.nuobao.common.entity;

import java.io.Serializable;

/**
 * 创建用户实体
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 22:06
 * @modify
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -8767474884137581857L;

    /**
     * 客户号
     */
    private String custNo;

    /**
     * 客户名称
     */
    private String custName;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 客户token
     */
    private String sessionToken;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "custNo='" + custNo + '\'' +
                ", custName='" + custName + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                '}';
    }
}
