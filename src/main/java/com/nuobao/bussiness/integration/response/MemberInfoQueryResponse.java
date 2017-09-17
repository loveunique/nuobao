package com.nuobao.bussiness.integration.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * 诺商认证信息查询响应报文
 *
 * @author Xu Chengzhi
 * @date 2017-09-07 九月 22:07
 * @modify
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberInfoQueryResponse extends BaseResponse {

    private static final long serialVersionUID = -3880593958166755577L;

    //企业名称
    @JSONField(name="corpor_name")
    private String corporName;

    //注册号
    @JSONField(name="cert_no")
    private String certNo;

    //法人
    @JSONField(name="legal_person")
    private String legalPerson;

    //注册地址
    @JSONField(name="regist_addr")
    private String registAddr;

    //认证状态
    @JSONField(name="auth_state")
    private String authState;

    //营业执照
    @JSONField(name="img_busi_lic_url")
    private String bussinessLicenseUrl;

    //营业执照有效期 YYYYMMDD 长期：99991231
    @JSONField(name="busi_lic_due", format = "yyyMMdd")
    private Date bussinessLicensePeriod = new Date("99991231");

    public MemberInfoQueryResponse() {
        super();
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
        return "MemberInfoQueryResponse{" +
                "corporName='" + corporName + '\'' +
                ", certNo='" + certNo + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", registAddr='" + registAddr + '\'' +
                ", authState='" + authState + '\'' +
                ", bussinessLicenseUrl='" + bussinessLicenseUrl + '\'' +
                ", bussinessLicensePeriod=" + bussinessLicensePeriod +
                '}';
    }
}
