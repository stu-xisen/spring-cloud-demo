package com.xisen.feigncomsumer9002;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider-8001")
public interface MyService {


    @GetMapping("hello")
    public String hello();

    @GetMapping("hello2")
    public String hello2(String name);

    @GetMapping("hello3/{name}")
    public String hello3(@PathVariable("name") String name);
}
