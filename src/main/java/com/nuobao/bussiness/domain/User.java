package com.nuobao.bussiness.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Xu Chengzhi
 * @date 2017-09-16 九月 19:53
 * @modify
 **/
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 7466301491691835432L;

    @Id
    @Column(name = "CB_USERNO", length = 12)
    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
