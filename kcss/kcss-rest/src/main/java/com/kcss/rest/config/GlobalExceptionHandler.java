package com.kcss.rest.config;

import com.kcss.biz.common.XResponse;
import com.kcss.core.exception.BaseException;
import com.kcss.core.exception.ErrorConstants;
import com.kcss.core.exception.RecordErrorConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler class.
 *
 * @author X
 * @date: 2018/11/14
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //处理自定义异常
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //响应吗
    @ResponseBody
    public XResponse handlerMyException(HttpServletRequest request,BaseException e){
        e.printStackTrace();
        if (e.getCode()== RecordErrorConstants.ERR_AUTH_INVALID_CAPTCHA){
            return new XResponse(){{
                setCode(500);
                setMessage(e.getCode());
            }};
        }
        return new XResponse(){{
            setCode(501);
            setMessage(e.getCode());
        }};
    }

    //处理自定义异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //响应吗
    @ResponseBody
    public XResponse handlerMyException(HttpServletRequest request,RuntimeException e){
        e.printStackTrace();
        return new XResponse(){{
            setCode(501);
            setMessage("exception now");
        }};
    }

    //处理自定义异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //响应吗
    @ResponseBody
    public XResponse handlerException(HttpServletRequest request,Exception e){
        e.printStackTrace();
        return new XResponse(){{
            setCode(501);
            setMessage(e.getLocalizedMessage());
        }};
    }

}
