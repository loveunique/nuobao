package com.nuobao.bussiness.service;

import java.util.Map;

/**
 * 创建图形码逻辑接口
 *
 * @author Xu Chengzhi
 * @date 2017-09-17 九月 9:02
 * @modify
 **/
public interface ImageCodeService {
	
	/**
	 * 获取图片验证码
	 * @param verifyWidthPerChar 图片中单个字母的宽度 像素
	 * @param verifyHeight 图片高度 像素
	 * @param charNum 图片中字母数量 
	 * @throws Exception
	 */
	Map<String,String> getImageCode(int verifyWidthPerChar, int verifyHeight, int charNum) throws Exception;

    /**
     * 验证图形码
     * @param key
     * @param verifyKey
     * @return Map<String,String>
     * @throws Exception
     */
	Map<String,String> checkImageCode(String key, String verifyKey) throws Exception;
}
