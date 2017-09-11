package com.nuobao.bussiness.integration.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * 诺商认证
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:54
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantIdentityRequestInput extends BaseRequest {

    private static final long serialVersionUID = -8236631851014908964L;

    //客户号 32 M
    @JSONField(name="cust_no")
    private String custNo;

    //企业名称 128 M
    @JSONField(name="corpor_name")
    private String corporName;

    //注册号 64 M
    @JSONField(name="cert_no")
    private String certNo;

    //法人 64 M
    @JSONField(name="legal_person")
    private String legalPerson;

    //注册地址 64 M
    @JSONField(name="regist_addr")
    private String registAddr;

    //认证状态 2 M
    @JSONField(name="auth_state")
    private String authState;

    //营业执照 图片URL 256 M
    @JSONField(name="img_busi_lic_url")
    private String bussinessLicenseUrl;

    //营业执照有效期 2 M  YYYYMMDD 长期：99991231
    @JSONField(name="busi_lic_due", format = "yyyMMdd")
    private Date bussinessLicensePeriod = new Date("99991231");

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCorporName() {
        return corporName;
    }

    public void setCorporName(String corporName) {
        this.corporName = corporName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegistAddr() {
        return registAddr;
    }

    public void setRegistAddr(String registAddr) {
        this.registAddr = registAddr;
    }

    public String getAuthState() {
        return authState;
    }

    public void setAuthState(String authState) {
        this.authState = authState;
    }

    public String getBussinessLicenseUrl() {
        return bussinessLicenseUrl;
    }

    public void setBussinessLicenseUrl(String bussinessLicenseUrl) {
        this.bussinessLicenseUrl = bussinessLicenseUrl;
    }

    public Date getBussinessLicensePeriod() {
        return bussinessLicensePeriod;
    }

    public void setBussinessLicensePeriod(Date bussinessLicensePeriod) {
        this.bussinessLicensePeriod = bussinessLicensePeriod;
    }

    @Override
    public String toString() {
        return "MerchantIdentityRequest{" +
                "custNo='" + custNo + '\'' +
                ", corporName='" + corporName + '\'' +
                ", certNo='" + certNo + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", registAddr='" + registAddr + '\'' +
                ", authState='" + authState + '\'' +
                ", bussinessLicenseUrl='" + bussinessLicenseUrl + '\'' +
                ", bussinessLicensePeriod=" + bussinessLicensePeriod +
                '}';
    }
}
