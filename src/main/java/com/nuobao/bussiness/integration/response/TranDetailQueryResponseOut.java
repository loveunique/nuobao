package com.nuobao.bussiness.integration.response;

import java.io.Serializable;
import java.util.List;

/**
 * 诺宝交易明细查询响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-12 九月 22:14
 * @modify
 **/
public class TranDetailQueryResponseOut implements Serializable {

    private static final long serialVersionUID = 9062390745779635414L;

    private List<TranDetail> tranDetails;

    public TranDetailQueryResponseOut() {
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
