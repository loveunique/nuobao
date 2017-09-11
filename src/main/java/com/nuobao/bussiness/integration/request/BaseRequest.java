package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 创建基础发送类
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:36
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -3861336179009804628L;

    //法人代码（机构代码） 32 M
    @JSONField(name="organ_id")
    private String organId;

    //渠道(00=APP 01= PC) 2 M
    @JSONField(name="channel")
    private String channel = "00";

    public BaseRequest() {
        super();
    }

    public BaseRequest(String organId, String channel) {
        this.organId = organId;
        this.channel = channel;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "organId='" + organId + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
