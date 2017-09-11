package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 会员信息更新
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:09
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberInfoModifyRequestInput implements Serializable {

    private static final long serialVersionUID = -2618517251255954964L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //身份证号 18 O
    @JSONField(name="cert_no")
    private String certNo;

    //姓名 64 O
    @JSONField(name="name")
    private String name;

    //归属区域 10 O
    @JSONField(name="area_belong")
    private String areaBelong;

    //身份证照片正面 图片URL 256 O
    @JSONField(name="img_front_url")
    private String imgFrontUrl;

    //身份证照片背面 图片URL 256 O
    @JSONField(name="img_back_url")
    private String imgBackUrl;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaBelong() {
        return areaBelong;
    }

    public void setAreaBelong(String areaBelong) {
        this.areaBelong = areaBelong;
    }

    public String getImgFrontUrl() {
        return imgFrontUrl;
    }

    public void setImgFrontUrl(String imgFrontUrl) {
        this.imgFrontUrl = imgFrontUrl;
    }

    public String getImgBackUrl() {
        return imgBackUrl;
    }

    public void setImgBackUrl(String imgBackUrl) {
        this.imgBackUrl = imgBackUrl;
    }

    @Override
    public String toString() {
        return "MemberInfoModifyRequestInput{" +
                "custNo='" + custNo + '\'' +
                ", certNo='" + certNo + '\'' +
                ", name='" + name + '\'' +
                ", areaBelong='" + areaBelong + '\'' +
                ", imgFrontUrl='" + imgFrontUrl + '\'' +
                ", imgBackUrl='" + imgBackUrl + '\'' +
                '}';
    }
}
