package com.nuobao.bussiness.controller;

import com.nuobao.bussiness.integration.request.*;
import com.nuobao.bussiness.repository.UserRepository;
import com.nuobao.bussiness.service.LoginService;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.result.OperationResult;
import com.nuobao.common.util.PhoneFormatCheckUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 创建登录接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 16:54
 * @modify
 **/
@RestController
@RequestMapping("/qz/sys")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginService loginService;

    /**
     * 会员登录
     * @param request
     * @return OperationResult
     * @throws Exception
     */
    @RequestMapping(path = "/login", method= RequestMethod.POST)
    public OperationResult login(@RequestBody LoginRequest request) throws Exception {
        logger.info("LoginController.login --> LoginRequest:{}", request);

        String mobileNo = request.getMobileNo();
        if(!PhoneFormatCheckUtils.isChinaPhoneLegal(mobileNo)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "手机号码格式错误");
        }

        String logonPwd = request.getLogonPwd();
        if(StringUtils.isEmpty(logonPwd)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "密码为空");
        }

        String organId = request.getOrganId();
        if(StringUtils.isEmpty(organId)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "法人代码为空");
        }

        OperationResult result = loginService.login(request);

        return result;
    }

    /**
     * 重置会员登录密码
     * @param request
     * @return OperationResult
     * @throws Exception
     */
    @RequestMapping(path = "/login_pwd_reset", method= RequestMethod.POST)
    public OperationResult loginPwdReset(@RequestBody LoginPasswordResetRequest request) throws Exception {
        logger.info("LoginController.login --> LoginPasswordResetRequest:{}", request);

        String custNo = request.getCustNo();
        if(StringUtils.isEmpty(custNo)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "客户号为空");
        }

        String logonPwd = request.getLogonPwd();
        if(StringUtils.isEmpty(logonPwd)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "登陆密码为空");
        }

        String organId = request.getOrganId();
        if(StringUtils.isEmpty(organId)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "法人代码为空");
        }

        OperationResult result = loginService.loginPwdReset(request);

        return result;
    }

    /**
     * 会员登录密码修改
     * @param request
     * @return OperationResult
     * @throws Exception
     */
    @RequestMapping(path = "/login_pwd_modify", method= RequestMethod.POST)
    public OperationResult loginPwdModify(@RequestBody LoginPasswordModifyRequest request) throws Exception {
        logger.info("LoginController.loginPwdModify --> LoginPasswordModifyRequest:{}", request);

        String custNo = request.getCustNo();
        if(StringUtils.isEmpty(custNo)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "客户号为空");
        }

        String logonPwdOld = request.getLogonPwdOld();
        if(StringUtils.isEmpty(logonPwdOld)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "旧登陆密码为空");
        }

        String logonPwdNew = request.getLogonPwdNew();
        if(StringUtils.isEmpty(logonPwdNew)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "新登陆密码为空");
        }

        String organId = request.getOrganId();
        if(StringUtils.isEmpty(organId)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "法人代码为空");
        }

        OperationResult result = loginService.loginPwdModify(request);

        return result;
    }

    /**
     * 会员交易密码修改
     * @param request
     * @return OperationResult
     * @throws Exception
     */
    @RequestMapping(path = "/tran_pwd_modify", method= RequestMethod.POST)
    public OperationResult tranPwdModify(@RequestBody TradePasswordModifyRequest request) throws Exception {
        logger.info("LoginController.tranPwdModify --> TradePasswordModifyRequest:{}", request);

        String custNo = request.getCustNo();
        if(StringUtils.isEmpty(custNo)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "客户号为空");
        }

        String tranPwdOld = request.getTranPwdOld();
        if(StringUtils.isEmpty(tranPwdOld)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "旧交易交易为空");
        }

        String tranPwdNew = request.getTranPwdNew();
        if(StringUtils.isEmpty(tranPwdNew)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "新交易密码为空");
        }

        String organId = request.getOrganId();
        if(StringUtils.isEmpty(organId)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "法人代码为空");
        }

        OperationResult result = loginService.tranPwdModify(request);

        return result;
    }

    /**
     * 会员交易密码重置
     * @param request
     * @return OperationResult
     * @throws Exception
     */
    @RequestMapping(path = "/tran_pwd_reset", method= RequestMethod.POST)
    public OperationResult tranPwdReset(@RequestBody TradePasswordResetRequest request) throws Exception {
        logger.info("LoginController.tranPwdReset --> TradePasswordResetRequest:{}", request);

        String custNo = request.getCustNo();
        if(StringUtils.isEmpty(custNo)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "客户号为空");
        }

        String tranPwd = request.getTranPwd();
        if(StringUtils.isEmpty(tranPwd)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "交易密码为空");
        }

        String organId = request.getOrganId();
        if(StringUtils.isEmpty(organId)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "法人代码为空");
        }

        OperationResult result = loginService.tranPwdReset(request);

        return result;
    }

    /**
     * 注册手机号码更换
     * @param request
     * @return OperationResult
     * @throws Exception
     */
    @RequestMapping(path = "/reg_mobile_change", method= RequestMethod.POST)
    public OperationResult mobileChange(@RequestBody MobileChangeRequest request) throws Exception {
        logger.info("LoginController.mobileChange --> MobileChangeRequest:{}", request);

        String custNo = request.getCustNo();
        if(StringUtils.isEmpty(custNo)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "客户号为空");
        }

        String mobileNoNew = request.getMobileNoNew();
        if(!PhoneFormatCheckUtils.isChinaPhoneLegal(mobileNoNew)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "手机号码格式错误");
        }

        String loginPwd = request.getLogonPwd();
        if(StringUtils.isEmpty(loginPwd)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "登陆密码为空");
        }

        String organId = request.getOrganId();
        if(StringUtils.isEmpty(organId)) {
            throw new TranFailException(ApplicationErrorCode.FAKE_TRAN_DATA, "法人代码为空");
        }

        OperationResult result = loginService.mobileChange(request);

        return result;
    }
}
