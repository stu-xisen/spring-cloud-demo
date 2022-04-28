package com.xisen.serviceprovider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServiceProviderApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication8001.class,args);
    }
}
