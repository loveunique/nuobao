package com.nuobao.bussiness.integration.request;

/**
 * 诺宝交易明细查询
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:05
 * @modify
 **/
public class TranDetailQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 5483823710493819898L;

    private TransferRequestInput input;

    public TranDetailQueryRequest() {
        super();
    }

    public TransferRequestInput getInput() {
        return input;
    }

    public void setInput(TransferRequestInput input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "TranDetailQueryRequest{" +
                "input=" + input +
                '}';
    }
}
