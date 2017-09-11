package com.nuobao.bussiness.integration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺商认证信息查询响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:07
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberInfoQueryResponse extends BaseResponse {

    private static final long serialVersionUID = -3880593958166755577L;

    private MemberInfoQueryResponseOut out;

    public MemberInfoQueryResponse() {
        super();
    }

    public MemberInfoQueryResponseOut getOut() {
        return out;
    }

    public void setOut(MemberInfoQueryResponseOut out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "MemberInfoQueryResponse{" +
                "out=" + out +
                '}';
    }
}
