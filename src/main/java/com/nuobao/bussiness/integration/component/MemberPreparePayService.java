package com.nuobao.bussiness.integration.component;

import com.nuobao.bussiness.integration.request.MemberInfoModifyRequest;
import com.nuobao.bussiness.integration.request.MemberPreparePayRequest;
import com.nuobao.bussiness.integration.response.BaseResponse;
import com.nuobao.bussiness.integration.response.MemberPreparePayResponse;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 创建普通会员开通为诺星会员
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:23
 * @modify
 **/
@Component
public class MemberPreparePayService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送普通会员开通为诺星会员
     * @param request
     * @return BaseResponse
     * @throws Exception
     */
    public MemberPreparePayResponse execute(MemberPreparePayRequest request) throws TranFailException {
        logger.info("MemberPreparePayService.execute: request:{}", request);

        try {
            MemberPreparePayResponse response = HttpUtil.callHostServerByPost(false, null,
                    "UTF-8", request, "/mem/create_nx_order_prepay", MemberPreparePayResponse.class);

            String resultCode = response.getResultCode();
            if(!"0".equals(resultCode)) {
                throw new TranFailException(resultCode, response.getResultMsg());
            }

            return response;
        } catch (BaseException e) {
            logger.error("LoginPasswordModifyService.BaseException: e:{}", e);
            throw e;
        } catch (Exception e) {
            logger.error("LoginPasswordModifyService.Exception: e:{}", e);
            throw new TranFailException(ApplicationErrorCode.SYSTEM_ERROR, "交易异常");
        }
    }
}
