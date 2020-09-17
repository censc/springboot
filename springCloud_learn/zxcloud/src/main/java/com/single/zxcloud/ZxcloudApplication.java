package com.single.zxcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZxcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxcloudApplication.class, args);
    }

}
