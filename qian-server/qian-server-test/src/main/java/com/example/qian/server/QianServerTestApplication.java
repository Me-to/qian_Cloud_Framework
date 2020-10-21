package com.example.qian.server;

import com.example.qian.annotation.EnableQianAuthExceptionHandler;
import com.example.qian.annotation.EnableQianOauth2FeignClient;
import com.example.qian.annotation.QianCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//@EnableQianAuthExceptionHandler
//@EnableQianOauth2FeignClient
//@EnableFeignClients
@QianCloudApplication
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class QianServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianServerTestApplication.class, args);
    }

}
