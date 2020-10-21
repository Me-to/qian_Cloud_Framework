package com.example.qian.configure;

import com.example.qian.interceptor.QianServerProtectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class QianServerProtectConfigure implements WebMvcConfigurer {
    @Autowired
    HandlerInterceptor qianServerProtectInterceptor;

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HandlerInterceptor qianServerProtectInterceptor() {
        return new QianServerProtectInterceptor();
    }

    //TODO
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(qianServerProtectInterceptor);
    }
}