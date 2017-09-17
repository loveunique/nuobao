package com.nuobao.bussiness.integration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 诺商会员线上购买诺券
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:43
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketPreparePayRequest extends BaseRequest{

    private static final long serialVersionUID = 6614300505929516504L;

    private TicketPreparePayRequestInput input;
}
