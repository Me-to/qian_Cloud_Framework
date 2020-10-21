package com.example.qian.annotation;

import com.example.qian.configure.QianAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(QianAuthExceptionConfigure.class)
public @interface EnableQianAuthExceptionHandler {

}