package com.kcss.biz.setting;


import com.kcss.core.exception.BaseException;
import com.kcss.core.exception.ErrorConstants;

public class SettingException extends BaseException {

    protected static String code = ErrorConstants.ERR_SETTING_EXCEPTION;

    public SettingException(String msg) {
        super(code, msg);
    }

}