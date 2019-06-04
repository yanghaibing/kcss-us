package com.kcss.core.exception;

public class UnImplementedException extends  BaseException {
    protected static String code = ErrorConstants.ERR_UNIMPLEMENTED_EXCEPTION;

    public UnImplementedException(String msg) {
        super(msg);
    }

    public UnImplementedException(String code, String msg) {
        super(code, msg);
    }
}
