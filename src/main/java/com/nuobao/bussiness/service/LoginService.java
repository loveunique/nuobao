package com.nuobao.bussiness.service;

import com.nuobao.bussiness.integration.request.*;
import com.nuobao.common.result.OperationResult;

/**
 * 创建登录逻辑接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-17 九月 9:02
 * @modify
 **/
public interface LoginService {

    /**
     * 会员登录
     * @param request
     * @return OperationResult
     */
    OperationResult login(LoginRequest request) throws Exception;

    /**
     * 重置会员登录密码
     * @param request
     * @return OperationResult
     */
    OperationResult loginPwdReset(LoginPasswordResetRequest request) throws Exception;

    /**
     * 会员登录密码修改
     * @param request
     * @return OperationResult
     */
    OperationResult loginPwdModify(LoginPasswordModifyRequest request) throws Exception;

    /**
     * 会员交易密码修改
     * @param request
     * @return OperationResult
     */
    OperationResult tranPwdModify(TradePasswordModifyRequest request) throws Exception;

    /**
     * 会员交易密码重置
     * @param request
     * @return OperationResult
     */
    OperationResult tranPwdReset(TradePasswordResetRequest request) throws Exception;

    /**
     * 注册手机号码更换
     * @param request
     * @return OperationResult
     */
    OperationResult mobileChange(MobileChangeRequest request) throws Exception;
}
