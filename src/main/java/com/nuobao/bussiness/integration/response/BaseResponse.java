package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 创建基础响应类
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 0:23
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable{

    private static final long serialVersionUID = 6921895287858373765L;

    public BaseResponse() {
        super();
    }

    //0=交易正常 其他交易非正常
    @JSONField(name="ec")
    private String resultCode;

    //响应信息
    @JSONField(name="em")
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
