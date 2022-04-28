package com.xisen.eureka7003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7003.class,args);
    }
}
