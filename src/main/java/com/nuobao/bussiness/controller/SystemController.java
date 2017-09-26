package com.nuobao.bussiness.controller;

import com.nuobao.bussiness.service.ImageCodeService;
import com.nuobao.bussiness.service.SystemService;
import com.nuobao.common.annotation.SessionCheck;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.form.ImageCodeForm;
import com.nuobao.common.result.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private SystemService systemService;

    /**
     * 获取请求随机数
     * @return OperationResult
     * @throws TranFailException
     */
    @SessionCheck(false)
    @RequestMapping(value = "/getSerialNo", method = RequestMethod.POST)
    public OperationResult getSerialNo() throws TranFailException{
        return systemService.getSerialNo();
    }

    /**
     *  获取图形验证码
     * @return OperationResult
     * @throws TranFailException
     */
    @SessionCheck(false)
    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    public OperationResult generateSimpleImageCode() throws TranFailException{
        logger.info("SystemController.generateSimpleImageCode");
        OperationResult result= new OperationResult();
        result.setBusinessDataObject(imageCodeService.getImageCode(4, 20, 25));
        return result;
    }

    /**
     *  验证图形验证码
     * @return OperationResult
     * @throws TranFailException
     */
    @SessionCheck(false)
    @RequestMapping(value = "/checkCode", method = RequestMethod.GET)
    public OperationResult checkImageCode(@RequestBody ImageCodeForm form) throws TranFailException{
        logger.info("SystemController.checkImageCode --> ImageCodeForm:{}", form);

        String key = form.getKey();
        String checkCode = form.getCheckCode();

        if(StringUtils.isEmpty(key) || StringUtils.isEmpty(checkCode)) {
            throw new TranFailException(ApplicationErrorCode.NOT_NULL, "图形验证码参数为空");
        }

        OperationResult result = new OperationResult();
        result.setBusinessDataObject(imageCodeService.checkImageCode(key, checkCode));
        return result;
    }


}
