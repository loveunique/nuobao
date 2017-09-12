package com.nuobao.bussiness.integration.response;

/**
 * 诺宝交易明细查询响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:14
 * @modify
 **/
public class TranDetailQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 3889229161564752L;

    private TranDetailQueryResponseOut out;

    public TranDetailQueryResponse() {
        super();
    }

    public TranDetailQueryResponseOut getOut() {
        return out;
    }

    public void setOut(TranDetailQueryResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "TranDetailQueryResponse{" +
                "out=" + out +
                '}';
    }
}
