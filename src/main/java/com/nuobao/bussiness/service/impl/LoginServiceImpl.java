package com.nuobao.bussiness.service.impl;

import com.nuobao.bussiness.integration.component.LoginSendService;
import com.nuobao.bussiness.integration.request.*;
import com.nuobao.bussiness.integration.response.LoginResponse;
import com.nuobao.bussiness.service.LoginService;
import com.nuobao.common.exception.BaseException;
import com.nuobao.common.result.OperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建登录逻辑接口实现类
 * @author Xu Chengzhi
 * @date 2017-09-17 九月 9:04
 * @modify
 **/
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginSendService loginSendService;

    /**
     * 会员登录
     *
     * @param request
     * @return OperationResult
     */
    @Override
    public OperationResult login(LoginRequest request) throws BaseException {
        OperationResult result = new OperationResult();
        LoginResponse response = loginSendService.execute(request);
        result.setBusinessDataObject(response);
        return result;
    }

    /**
     * 重置会员登录密码
     *
     * @param request
     * @return OperationResult
     */
    @Override
    public OperationResult loginPwdReset(LoginPasswordResetRequest request) throws BaseException{
        return null;
    }

    /**
     * 会员登录密码修改
     *
     * @param request
     * @return OperationResult
     */
    @Override
    public OperationResult loginPwdModify(LoginPasswordModifyRequest request) throws BaseException{
        return null;
    }

    /**
     * 会员交易密码修改
     *
     * @param request
     * @return OperationResult
     */
    @Override
    public OperationResult tranPwdModify(TradePasswordModifyRequest request) throws BaseException{
        return null;
    }

    /**
     * 会员交易密码重置
     *
     * @param request
     * @return OperationResult
     */
    @Override
    public OperationResult tranPwdReset(TradePasswordResetRequest request) throws BaseException{
        return null;
    }

    /**
     * 注册手机号码更换
     *
     * @param request
     * @return OperationResult
     */
    @Override
    public OperationResult mobileChange(MobileChangeRequest request) throws BaseException{
        return null;
    }
}
