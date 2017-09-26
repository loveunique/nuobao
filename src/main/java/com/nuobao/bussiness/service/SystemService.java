package com.nuobao.bussiness.service;

import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.result.OperationResult;

/**
 * 创建系统逻辑接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-17 九月 9:04
 * @modify
 **/
public interface SystemService {

    /**
     * 获取请求随机数
     * @return OperationResult
     * @throws TranFailException
     */
    OperationResult getSerialNo() throws TranFailException;
}
