package com.kcss.admin.auth.privilege;

public enum RoleStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    ;

    private final String label;

    RoleStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}