package com.yulaiz.fund.note.service.config.rest.controllerAdvice;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.config.exception.FundNoteException;
import com.yulaiz.fund.note.service.config.rest.response.RestResponse;
import com.yulaiz.fund.note.service.config.rest.response.RestResponseBuilder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Log log = LogFactory.get();

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(FundNoteException.class)
    @ResponseBody
    public RestResponse handleExeResultException(FundNoteException e) {
        return RestResponseBuilder.createFailBuilder(e.getMessage()).builder();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> errorList = e.getBindingResult().getFieldErrors();
        StringBuffer sb = new StringBuffer();
        for (FieldError fieldError : errorList) {
            sb.append(fieldError.getDefaultMessage());
            sb.append(", ");
        }
        String message = sb.substring(0, sb.length() - 2);
        return RestResponseBuilder.createFailBuilder(message).builder();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public RestResponse handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage());
        return RestResponseBuilder.createFailBuilder("操作数据库失败").builder();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public RestResponse handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage());
        if (e.getMessage().indexOf("java.util.Date") != -1) {
            return RestResponseBuilder.createFailBuilder("日期格式有误").builder();
        }
        return RestResponseBuilder.createFailBuilder().builder();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResponse handleException(Exception e) {
        log.error(e.getMessage());
        return RestResponseBuilder.createFailBuilder().builder();
    }
}
