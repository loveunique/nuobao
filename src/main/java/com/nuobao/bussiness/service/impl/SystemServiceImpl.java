package com.nuobao.bussiness.service.impl;

import com.nuobao.bussiness.service.SystemService;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.redis.CacheSettings;
import com.nuobao.common.redis.RedisUtil;
import com.nuobao.common.result.OperationResult;
import com.nuobao.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 创建系统逻辑接口实现类
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 21:41
 * @modify
 **/
@Service
public class SystemServiceImpl implements SystemService{

    @Autowired
    private CacheSettings cacheSettings;

    /**
     * 获取请求随机数
     * @return OperationResult
     * @throws TranFailException
     */
    @Override
    public OperationResult getSerialNo() throws TranFailException {
        OperationResult operationResult = new OperationResult();

        String serialNum = MD5Util.encodeByMD5(UUID.randomUUID().toString());
        RedisUtil.put(cacheSettings.getCacheName(), serialNum, serialNum);

        operationResult.setBusinessDataObject(serialNum);

        return operationResult;
    }
}
