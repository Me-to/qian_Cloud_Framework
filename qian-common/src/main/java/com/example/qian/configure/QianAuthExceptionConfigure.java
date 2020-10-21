package com.example.qian.configure;

import com.example.qian.hanadler.QianAccessDeniedHandler;
import com.example.qian.hanadler.QianAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class QianAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public QianAccessDeniedHandler accessDeniedHandler() {
        return new QianAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public QianAuthExceptionEntryPoint authenticationEntryPoint() {
        return new QianAuthExceptionEntryPoint();
    }
}