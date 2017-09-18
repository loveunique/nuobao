package com.nuobao.bussiness.service.impl;

import com.nuobao.bussiness.domain.UserImage;
import com.nuobao.bussiness.repository.UserImageRepository;
import com.nuobao.bussiness.service.FileService;
import com.nuobao.common.constant.ApplicationErrorCode;
import com.nuobao.common.exception.TranFailException;
import com.nuobao.common.result.OperationResult;
import com.nuobao.common.util.FileCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

/**
 * 创建文件逻辑接口实现类
 * @author Xu Chengzhi
 * @date 2017-09-18 九月 22:18
 * @modify
 **/
@Service
public class FileServiceImpl implements FileService{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserImageRepository userImageRepository;

    /**
     * 保存文件
     *
     * @param file
     * @param custNo
     * @param imageType
     * @return OperationResult
     */
    @Override
    @Transactional
    public OperationResult saveFile(MultipartFile file, String custNo, String imageType) throws TranFailException{
        logger.info("FileController.fileUpload -- > file:{}, custNo:{}, imageType:{}", file, custNo, imageType);

        OperationResult operationResult = new OperationResult();
        try {
            File newFile = FileCommonUtil.getNewFileName(custNo, file.getOriginalFilename());
            file.transferTo(newFile);

            UserImage userImage = new UserImage();
            userImage.setCustNo(custNo);
            userImage.setImageType(imageType);
            userImage.setImagePath(newFile.getAbsolutePath());

            userImage = userImageRepository.save(userImage);
            operationResult.setBusinessDataObject(userImage.getImageId());

            return operationResult;
        } catch (IOException ie) {
            logger.info("FileController.fileUpload -- > IOException:{}", ie);
            throw new TranFailException(ApplicationErrorCode.SYSTEM_WITHMESSAGE_ERROR, "文件保存失败");
        }
    }
}
