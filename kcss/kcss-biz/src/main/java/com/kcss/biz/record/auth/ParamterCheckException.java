package com.kcss.biz.record.auth;

import com.kcss.core.exception.BaseException;
import com.kcss.core.exception.ErrorConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class ParamterCheckException extends BaseException {

    protected static String code = ErrorConstants.ERR_MISSING_PARAMETER;


    public ParamterCheckException(String code, String msg) {
        super(code, msg);
    }
    public ParamterCheckException(String code) {
        super(code, null);
    }

    public ParamterCheckException() {
        super(code, null);
    }

}
