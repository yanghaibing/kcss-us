package com.kcss.admin.auth.privilege;

public enum RoleType {
    PRIVILEGE("PRIVILEGE"),
    ;

    private final String label;

    RoleType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}