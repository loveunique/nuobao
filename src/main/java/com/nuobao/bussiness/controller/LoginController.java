package com.nuobao.bussiness.controller;

import com.nuobao.bussiness.integration.request.LoginRequest;
import com.nuobao.bussiness.repository.UserRepository;
import com.nuobao.common.result.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserRepository userRepository;

    @RequestMapping(path = "/login", method= RequestMethod.POST)
    public OperationResult login(@RequestBody LoginRequest request) {
        logger.info("LoginController.login --> request:{}", request);
        OperationResult result = new OperationResult();

        userRepository.findByUserNo("");

        return result;
    }
}
