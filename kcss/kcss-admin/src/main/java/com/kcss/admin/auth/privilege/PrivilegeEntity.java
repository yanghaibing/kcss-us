package com.kcss.admin.auth.privilege;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class PrivilegeEntity {

    private long id;
    private Privilege name;
    private PrivilegeType type;
    private PrivilegeStatus status;
    private String param;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Privilege getName() {
        return name;
    }

    public void setName(Privilege name) {
        this.name = name;
    }

    public PrivilegeType getType() {
        return type;
    }

    public void setType(PrivilegeType type) {
        this.type = type;
    }

    public PrivilegeStatus getStatus() {
        return status;
    }

    public void setStatus(PrivilegeStatus status) {
        this.status = status;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public enum PrivilegeType {
        BUSINESS,
        SYSTEM,
        CUSTOMER,
        FINANCE,
        REVIEW,
        COLLECTION,
        REPORT
    }

    public enum PrivilegeStatus {
        ACTIVE,
        INACTIVE
    }
}
