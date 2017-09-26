package com.nuobao.common.form;

import java.io.Serializable;

/**
 * 图形验证码Form
 *
 * @author Xu Chengzhi
 * @date 2017-09-19 九月 21:55
 * @modify
 **/
public class ImageCodeForm implements Serializable {

    private static final long serialVersionUID = -8238198758970475963L;

    /**
     * 图形验证码key
     */
    private String key;

    /**
     * 图片验证码
     */
    private String checkCode;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String toString() {
        return "ImageCodeForm{" +
                "key='" + key + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }
}
