package com.example.qian.auth;

import com.example.qian.annotation.EnableQianAuthExceptionHandler;
import com.example.qian.annotation.QianCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableQianAuthExceptionHandler
@QianCloudApplication
@MapperScan("com.example.qian.auth.mapper")
public class QianAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianAuthApplication.class, args);
    }

}
