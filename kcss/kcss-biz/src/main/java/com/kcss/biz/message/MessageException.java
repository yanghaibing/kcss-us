package com.kcss.biz.message;

import com.kcss.core.exception.BaseException;
import com.kcss.core.exception.ErrorConstants;

public class MessageException extends BaseException {
    protected static String code = ErrorConstants.ERR_MESSAGE_EXCEPTION;

    public MessageException(String msg) {
        super(code, msg);
    }
}
