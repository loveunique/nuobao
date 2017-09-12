package com.nuobao.bussiness.integration.request;

/**
 * 诺宝账户之间转账
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 21:48
 * @modify
 **/
public class TransferRequest extends BaseRequest{

    private static final long serialVersionUID = 2925951612118157671L;

    private TransferRequestInput input;

    public TransferRequest() {
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
        return "TransferRequest{" +
                "input=" + input +
                '}';
    }
}
