package com.nuobao.bussiness.integration.response;

import java.util.List;

/**
 * 诺宝交易明细查询响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:14
 * @modify
 **/
public class TranDetailQueryResponse extends BaseResponse {

    private static final long serialVersionUID = 3889229161564752L;

    private List<TranDetail> tranDetails;

    public TranDetailQueryResponse() {
        super();
    }

    public List<TranDetail> getTranDetails() {
        return tranDetails;
    }

    public void setTranDetails(List<TranDetail> tranDetails) {
        this.tranDetails = tranDetails;
    }

    @Override
    public String toString() {
        return "TranDetailQueryResponse{" +
                "tranDetails=" + tranDetails +
                '}';
    }
}
