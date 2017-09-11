package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 会员交易密码重置
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 21:47
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePasswordResetRequest extends BaseRequest{

    private static final long serialVersionUID = 9199166669325925447L;

    private TradePasswordResetRequestInput input;

    public TradePasswordResetRequest() {
        super();
    }

    public TradePasswordResetRequest(String organId, String channel) {
        super(organId, channel);
    }

    public TradePasswordResetRequestInput getInput() {
        return input;
    }

    public void setInput(TradePasswordResetRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "TradePasswordResetRequestInput{" +
                "input=" + input +
                '}';
    }
}
