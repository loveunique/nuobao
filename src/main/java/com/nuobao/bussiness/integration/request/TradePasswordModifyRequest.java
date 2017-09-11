package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员交易密码修改
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePasswordModifyRequest extends BaseRequest{

    private static final long serialVersionUID = 5557457685679403090L;

    private TradePasswordModifyRequestInput input;

    public TradePasswordModifyRequest() {
        super();
    }

    public TradePasswordModifyRequest(String organId, String channel) {
        super(organId, channel);
    }

    public TradePasswordModifyRequestInput getInput() {
        return input;
    }

    public void setInput(TradePasswordModifyRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "TradePasswordModifyRequestInput{" +
                "input=" + input +
                '}';
    }
}
