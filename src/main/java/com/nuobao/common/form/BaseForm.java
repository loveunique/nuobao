package com.nuobao.common.form;

import java.io.Serializable;

/**
 * 创建基础表单提交类
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 21:10
 * @modify
 **/
public class BaseForm implements Serializable {

    private static final long serialVersionUID = 950652613422269493L;

    /**
     * 请求Token
     */
    private String requestToken;

    /**
     * 客戶端IP
     */
    private String clientIp;

    private String httpSessionId;

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getHttpSessionId() {
        return httpSessionId;
    }

    public void setHttpSessionId(String httpSessionId) {
        this.httpSessionId = httpSessionId;
    }

    @Override
    public String toString() {
        return "BaseForm{" +
                "requestToken='" + requestToken + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", httpSessionId='" + httpSessionId + '\'' +
                '}';
    }
}
