package com.nuobao.bussiness.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 创建用户图像实体
 *
 * @author Xu Chengzhi
 * @date 2017-09-18 九月 21:50
 * @modify
 **/
@Entity
@Table(name = "T_USER_IMAGE")
public class UserImage implements Serializable{

    private static final long serialVersionUID = -3357583588634667661L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "TUI_IMAGE_ID", length = 32, columnDefinition = "VARCHAR")
    private String imageId;

    @Column(name = "TUI_CUST_NO", length = 32, columnDefinition = "VARCHAR")
    private String custNo;

    //图像类型
    //01 -- 身份证正面 02 -- 身份证反面 10 -- 营业执照正面 11 -- 营业执照背面 00 -- 用途头像
    @Column(name = "TUI_IMAGE_TYPE", length = 2, columnDefinition = "VARCHAR")
    private String imageType;

    @Column(name = "TUI_IMAGE_PATH", length = 128, columnDefinition = "VARCHAR")
    private String imagePath;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "UserImage{" +
                "imageId='" + imageId + '\'' +
                ", custNo='" + custNo + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
