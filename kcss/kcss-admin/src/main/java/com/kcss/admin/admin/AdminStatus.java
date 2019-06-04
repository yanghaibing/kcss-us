package com.kcss.admin.admin;

import com.kcss.core.util.jackson.I18NEnum;

/**
 * Created by jesse on 2017/2/23.
 * updateTime 2018-5-16 14:18:09
 * 添加“ALL”枚举值
 */
public enum  AdminStatus implements I18NEnum {
    ACTIVE("enum.admin.status.active"),
    INACTIVE("enum.admin.status.inactive"),
    DISABLED("enum.admin.status.disabled"),
    FREEZE("enum.admin.status.freeze"),
    ALL("enum.admin.status.all"),
    ;

    private String code;

    AdminStatus(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }

}
