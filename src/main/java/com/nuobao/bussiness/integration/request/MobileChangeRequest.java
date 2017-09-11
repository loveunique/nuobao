package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 注册手机号码更换
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:58
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileChangeRequest extends BaseRequest{

    private static final long serialVersionUID = -5971300361889996275L;

    private MobileChangeRequestInput input;

    public MobileChangeRequest() {
        super();
    }

    public MobileChangeRequest(String organId, String channel) {
        super(organId, channel);
    }

    public MobileChangeRequestInput getInput() {
        return input;
    }

    public void setInput(MobileChangeRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MobileChangeRequest{" +
                "input=" + input +
                '}';
    }
}
