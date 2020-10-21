package com.example.qian.annotation;

import com.example.qian.configure.QianServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(QianServerProtectConfigure.class)
public @interface EnableQianServerProtect {

}