package com.nuobao.common.util;

import java.util.Formatter;

/**
 * 字符串工具类
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 21:31
 * @modify
 **/
public class StringUtil {

    /**
     * byte转16位字符串
     * @param hash
     * @return String
     */
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
