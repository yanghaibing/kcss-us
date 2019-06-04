package com.kcss.admin.auth.privilege;

import com.kcss.core.exception.BaseException;
import com.kcss.core.exception.ErrorConstants;

public class PrivilegeException extends BaseException {

    protected static String code = ErrorConstants.ERR_NO_SUCH_PRIVILEGE;

    public PrivilegeException(String msg) {
        super(code, msg);
    }

}
