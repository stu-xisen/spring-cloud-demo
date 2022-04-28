package com.xisen.serviceprovider8001;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-provider-8002")
public interface MyService {


    @GetMapping(value = "hello")
    public String hello();

    @GetMapping(value = "hello2")
    public String hello2(String name);
}
