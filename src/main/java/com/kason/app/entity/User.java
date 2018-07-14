package com.kason.app.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private Integer role;

    private String token;

    private Date createDate;

    private Integer status;

    private String wecharOpenid;

    private String qqNumber;

    private String qqOpenid;

    private Integer cerId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWecharOpenid() {
        return wecharOpenid;
    }

    public void setWecharOpenid(String wecharOpenid) {
        this.wecharOpenid = wecharOpenid == null ? null : wecharOpenid.trim();
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
    }

    public Integer getCerId() {
        return cerId;
    }

    public void setCerId(Integer cerId) {
        this.cerId = cerId;
    }
}