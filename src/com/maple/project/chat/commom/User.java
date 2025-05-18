package com.maple.project.chat.commom;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author FENGXIN
 * 用户类 序列化
 **/
public class User implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String pwd;
    
    public String getUsername () {
        return username;
    }
    
    public void setUsername (String username) {
        this.username = username;
    }
    
    public String getPwd () {
        return pwd;
    }
    
    public void setPwd (String pwd) {
        this.pwd = pwd;
    }
    
    public User () {
    }
    
    public User (String username , String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
}
