package com.kcss.admin.auth;

import com.kcss.core.exception.AdminErrorConstants;
import com.kcss.core.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthException extends BaseException {

    protected static String code = AdminErrorConstants.ERR_ADMIN_AUTH;

    public AuthException(String code, String msg) {
        super(code, msg);
    }

    public AuthException(String msg) {
        super(code, msg);
    }
    
}
