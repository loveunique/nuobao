package com.nuobao.bussiness.controller;

import com.nuobao.bussiness.constant.ImageTypeConstant;
import com.nuobao.bussiness.service.FileService;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.result.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传
 *
 * @author Xu Chengzhi
 * @date 2017-09-18 九月 21:30
 * @modify
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileService fileService;

    /**
     * 上传一个文件
     * @param request
     * @return OperationResult
     * @throws TranFailException
     */
    @RequestMapping(value = "/oneUpload", method = RequestMethod.POST)
    public @ResponseBody OperationResult fileUpload(HttpServletRequest request) throws TranFailException{
        logger.info("FileController.fileUpload -- > request:{}", request);
        OperationResult operationResult = new OperationResult();

        MultipartFile file = ((MultipartHttpServletRequest)request).getFile("fileName");
        if(file == null || file.isEmpty()){
            throw new TranFailException(ApplicationErrorCode.CLASS_NOT_EXIST, "文件不存在或为空");
        }

        String custNo = request.getParameter("custNo");
        if(StringUtils.isEmpty(custNo)) {
            throw new TranFailException(ApplicationErrorCode.NOT_NULL, "客户号为空");
        }

        String imageType = request.getParameter("imageType");
        if(StringUtils.isEmpty(imageType)) {
            throw new TranFailException(ApplicationErrorCode.NOT_NULL, "图像类别为空");
        }

        if(!(ImageTypeConstant.USER_ICON.equals(imageType) || ImageTypeConstant.USER_ID_FRONT.equals(imageType)
                || ImageTypeConstant.USER_ID_BACK.equals(imageType) || ImageTypeConstant.COPOR_ID_FRONT.equals(imageType)
                || ImageTypeConstant.COPOR_ID_BACK.equals(imageType))) {
            throw new TranFailException(ApplicationErrorCode.NOT_NULL, "图像类别错误");
        }

        operationResult = fileService.saveFile(file, custNo, imageType);

        return operationResult;
    }
}
