package com.example.qian.hanadler;

import com.example.qian.entity.QianResponse;
import com.example.qian.exception.QianAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public QianResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new QianResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = QianAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public QianResponse handleQianAuthException(QianAuthException e) {
        log.error("系统错误", e);
        return new QianResponse().message(e.getMessage());
    }
    
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public QianResponse handleAccessDeniedException(){
        return new QianResponse().message("没有权限访问该资源");
    }
}