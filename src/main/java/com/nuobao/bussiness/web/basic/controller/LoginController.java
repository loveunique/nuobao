package com.nuobao.bussiness.web.basic.controller;

import com.nuobao.bussiness.integration.request.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/login", method= RequestMethod.POST)
    public String login(@RequestBody LoginRequest request) {
        logger.info("LoginController.login --> request:{}", request);

        return "";
    }
}
