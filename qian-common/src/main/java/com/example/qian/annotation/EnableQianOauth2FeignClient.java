package com.example.qian.annotation;

import com.example.qian.configure.QianOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(QianOAuth2FeignConfigure.class)
public @interface EnableQianOauth2FeignClient {

}