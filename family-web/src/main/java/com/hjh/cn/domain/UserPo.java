package com.hjh.cn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 89lovelc on 2017/5/5.
 */

@Entity
@Table(name = "user")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class UserPo extends ParentPo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private String userId;

    private String userName;

    private String userPassword;

    private String tel;

    private String email;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
