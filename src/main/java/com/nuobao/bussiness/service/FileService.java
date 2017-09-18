package com.nuobao.bussiness.service;

import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.result.OperationResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 创建文件逻辑接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-18 九月 22:15
 * @modify
 **/
public interface FileService {

    /**
     * 保存文件
     * @param file
     * @param custNo
     * @param imageType
     * @return OperationResult
     */
    OperationResult saveFile(MultipartFile file, String custNo, String imageType) throws TranFailException;
}
