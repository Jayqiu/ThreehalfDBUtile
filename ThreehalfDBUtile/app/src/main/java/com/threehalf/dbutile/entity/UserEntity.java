package com.threehalf.dbutile.entity;

import com.threehalf.dbutile.annotation.Table;

import java.io.Serializable;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/19 18:14
 */
@Table(tabName="user")
public class UserEntity implements Serializable{
    private  String userName;
    private  String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

