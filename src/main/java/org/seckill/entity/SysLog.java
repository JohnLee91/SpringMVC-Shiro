/*
 * SysLog.java
 * Copyright(C) 2016-2020 �Ĵ�ʡ������о�Ժ
 * All rights reserved.
 * -----------------------------------------
 * 2017-07-04 Created.
 */
package org.seckill.entity;

import java.util.Date;

/**
 * 
 * @author scics
 * @version 1.0 2017-07-04
 */
public class SysLog {

    /**
     * ����ID
     */
    private Long id;
    /**
     * �û�ID
     */
    private Long userId;

    private User user;
    /**
     * �û���
     */
    private String username;
    /**
     * IP
     */
    private String ip;
    /**
     * ģ������
     */
    private String moduleName;
    /**
     * ����
     */
    private String options;
    /**
     * ��������
     */
    private String content;
    /**
     * ����ʱ��
     */
    private Date optTime;
    /**
     * �Ƿ����
     */
    private Short available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public Short getAvailable() {
        return available;
    }

    public void setAvailable(Short available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", options='" + options + '\'' +
                ", content='" + content + '\'' +
                ", optTime=" + optTime +
                '}';
    }
}