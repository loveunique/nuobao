package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 创建登录返回信息
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 0:25
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseOut implements Serializable{

    private static final long serialVersionUID = 7598983489343731597L;

    //客户号
    @JSONField(name="cust_no")
    private String custNo;

    //会员名称
    @JSONField(name="alias")
    private String alias;

    //会员姓名
    @JSONField(name="name")
    private String name;

    //身份证号码
    @JSONField(name="cert_no")
    private String certNo;

    //星级 1=一星 2=二星 3=三星 4=四星 5=五星
    @JSONField(name="star_lvl")
    private String starLevel;

    //归属区域
    @JSONField(name="area_belong")
    private String areaBelong;

    //会员状态 0=正常 1=冻结 2=注销
    @JSONField(name="state")
    private String state;

    //上级会员号
    @JSONField(name="up_cust_no")
    private String upperCustNo;

    //上级会员姓名
    @JSONField(name="up_cust_name")
    private String upperCustName;

    //上级会员手机号
    @JSONField(name="up_cust_mobile")
    private String upperMobileNo;

    //推荐会员号
    @JSONField(name="rec_cust_no")
    private String recCustNo;

    //推荐会员姓名
    @JSONField(name="rec_cust_name")
    private String recCustName;

    //推荐会员手机号
    @JSONField(name="rec_cust_mobile")
    private String recMobileNo;

    //归属城市总部
    @JSONField(name="head_quarter")
    private String heedQuarter;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getAreaBelong() {
        return areaBelong;
    }

    public void setAreaBelong(String areaBelong) {
        this.areaBelong = areaBelong;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUpperCustNo() {
        return upperCustNo;
    }

    public void setUpperCustNo(String upperCustNo) {
        this.upperCustNo = upperCustNo;
    }

    public String getUpperCustName() {
        return upperCustName;
    }

    public void setUpperCustName(String upperCustName) {
        this.upperCustName = upperCustName;
    }

    public String getUpperMobileNo() {
        return upperMobileNo;
    }

    public void setUpperMobileNo(String upperMobileNo) {
        this.upperMobileNo = upperMobileNo;
    }

    public String getRecCustNo() {
        return recCustNo;
    }

    public void setRecCustNo(String recCustNo) {
        this.recCustNo = recCustNo;
    }

    public String getRecCustName() {
        return recCustName;
    }

    public void setRecCustName(String recCustName) {
        this.recCustName = recCustName;
    }

    public String getRecMobileNo() {
        return recMobileNo;
    }

    public void setRecMobileNo(String recMobileNo) {
        this.recMobileNo = recMobileNo;
    }

    public String getHeedQuarter() {
        return heedQuarter;
    }

    public void setHeedQuarter(String heedQuarter) {
        this.heedQuarter = heedQuarter;
    }

    @Override
    public String toString() {
        return "LoginResponseOut{" +
                "custNo='" + custNo + '\'' +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", certNo='" + certNo + '\'' +
                ", starLevel='" + starLevel + '\'' +
                ", areaBelong='" + areaBelong + '\'' +
                ", state='" + state + '\'' +
                ", upperCustNo='" + upperCustNo + '\'' +
                ", upperCustName='" + upperCustName + '\'' +
                ", upperMobileNo='" + upperMobileNo + '\'' +
                ", recCustNo='" + recCustNo + '\'' +
                ", recCustName='" + recCustName + '\'' +
                ", recMobileNo='" + recMobileNo + '\'' +
                ", heedQuarter='" + heedQuarter + '\'' +
                '}';
    }
}
