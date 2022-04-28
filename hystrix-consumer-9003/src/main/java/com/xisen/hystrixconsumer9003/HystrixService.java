package com.xisen.hystrixconsumer9003;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "hystrix-service-provider-8003")
public interface HystrixService {


    @GetMapping(value = "service_ok/{id}")
    public String service_ok(@PathVariable("id") Integer id);


    @GetMapping(value = "service_timeout/{id}")
    public String service_timeout(@PathVariable("id") Integer id);
}
