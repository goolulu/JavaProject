package com.example.demo.domain;


import java.util.Date;

/**
 * @author  huangrn
 * @date  2020/11/29 18:17
 * @version 1.0
 */
public class User  {
    private Integer id;

    private String username;

    private String password;

    private String role;

    private Date createTime;

    private Date loginTime;

    private Date logoutTime;

    private String ipAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String toString() {
        System.out.println(id);
        System.out.println(username);
        System.out.println(password);
        return id +":"+username+":"+password;
    }
}