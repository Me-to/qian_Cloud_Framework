package com.example.qian.annotation;

import com.example.qian.selector.QianCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(QianCloudApplicationSelector.class)
public @interface QianCloudApplication {

}