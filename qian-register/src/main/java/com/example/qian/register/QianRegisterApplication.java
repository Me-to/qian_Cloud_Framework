package com.example.qian.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class QianRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(QianRegisterApplication.class, args);
    }

}
