package com.kcss.admin.auth.privilege.domain;

import com.kcss.admin.auth.privilege.Privilege;
import com.kcss.admin.auth.privilege.PrivilegeEntity;

public class PrivilegeDomain {
    private long id;
    private Privilege name;
    private PrivilegeEntity.PrivilegeType type;
    private PrivilegeEntity.PrivilegeStatus status;
    private String param;
    private String description;

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

    public PrivilegeEntity.PrivilegeType getType() {
        return type;
    }

    public void setType(PrivilegeEntity.PrivilegeType type) {
        this.type = type;
    }

    public PrivilegeEntity.PrivilegeStatus getStatus() {
        return status;
    }

    public void setStatus(PrivilegeEntity.PrivilegeStatus status) {
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

    @Override
    public String toString() {
        return "PrivilegeDomain{" +
                "id=" + id +
                ", name=" + name +
                ", type=" + type +
                ", status=" + status +
                ", param='" + param + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
