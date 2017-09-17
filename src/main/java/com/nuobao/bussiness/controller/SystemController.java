package com.nuobao.bussiness.controller;

import com.nuobao.bussiness.service.ImageCodeService;
import com.nuobao.common.result.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建系统控制器
 * @author Xu Chengzhi
 * @date 2017-09-17 九月 9:03
 * @modify
 **/
@RestController
@RequestMapping("/system")
public class SystemController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ImageCodeService imageCodeService;

    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public OperationResult generateSimpleImageCode() throws Exception{
        logger.info("SystemController.generateSimpleImageCode");
        OperationResult result= new OperationResult();
        result.setBusinessDataObject(imageCodeService.getImageCode(4, 20, 25));
        return result;
    }
}
