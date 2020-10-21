package com.example.qian.server.configure;


import com.example.qian.hanadler.QianAccessDeniedHandler;
import com.example.qian.hanadler.QianAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class QianServerTestResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private QianAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private QianAuthExceptionEntryPoint exceptionEntryPoint;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                 .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
