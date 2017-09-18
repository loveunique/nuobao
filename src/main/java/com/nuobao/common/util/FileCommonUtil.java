package com.nuobao.common.util;

import org.springframework.util.StringUtils;

import java.io.File;

/**
 * 创建文件工具类
 *
 * @author Xu Chengzhi
 * @date 2017-09-18 九月 21:55
 * @modify
 **/
public class FileCommonUtil {

    public static final String FILE_PATH = "D://TMP//";

    public static File getNewFileName(String prefix, String oldFileName) {
        String fileType = oldFileName.substring(oldFileName.lastIndexOf(".") -1);
        String fileName = DateUtil.getCurrentDateTimeWithoutSign() + fileType;
        if(!StringUtils.isEmpty(prefix)) {
            fileName += prefix + "_";
        }
        File newFile = new File(FILE_PATH + fileName);
        //判断文件父目录是否存在
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdir();
        }

        return newFile;
    }
}
