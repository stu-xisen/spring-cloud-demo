package com.xisen.eureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7001.class,args);
    }
}
