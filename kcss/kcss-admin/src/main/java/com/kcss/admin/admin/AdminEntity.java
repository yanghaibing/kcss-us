package com.kcss.admin.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by jesse on 2017/2/23.
 */
public class AdminEntity {
    private long id;
    private String mobile;
    @JsonIgnore
    private String password;
    private String fullName;
    private AdminType type;
    private AdminStatus status;
    @JsonIgnore
    private int failedLoginCount;
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AdminType getType() {
        return type;
    }

    public void setType(AdminType type) {
        this.type = type;
    }

    public AdminStatus getStatus() {
        return status;
    }

    public void setStatus(AdminStatus status) {
        this.status = status;
    }

    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(int failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", failedLoginCount=" + failedLoginCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
