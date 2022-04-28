package com.xisen.hystrixconsumer9003;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "globalTimeoutHandler")
public class HystrixConsumerController {


    @Value("${server.port}")
    String port;


    @Autowired
    HystrixService hystrixService;

    @HystrixCommand
    @GetMapping(value = "service_ok/{id}")
    public String service_ok(@PathVariable("id") Integer id){
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hystrixService.service_ok(id);
    }


    @HystrixCommand(fallbackMethod = "timeoutHandler")
    @GetMapping(value = "service_timeout/{id}")
    public String service_timeout(@PathVariable("id") Integer id){
        return hystrixService.service_timeout(id);
    }


    /**
     * 服务降级处理方法
     * @param id
     * @return
     */
    public String timeoutHandler(Integer id){
        return "port:" +port+" service:hystrix-service-provider-8003 timeout,线程池:" + Thread.currentThread().getName() + " service_timeout,id:" + id;
    }

    public String globalTimeoutHandler(){
        return "port:" +port+" service:hystrix-service-provider-8003 timeout,线程池:" + Thread.currentThread().getName() + " service_timeout";
    }


}
