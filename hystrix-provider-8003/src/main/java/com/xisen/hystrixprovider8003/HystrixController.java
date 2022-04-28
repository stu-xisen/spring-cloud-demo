package com.xisen.hystrixprovider8003;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


/**
 * 服务端熔断降级
 */
@RestController
public class HystrixController {

    @Value("${server.port}")
    String port;

    /**
     * 服务正常调用
     * @param id
     * @return
     */
    @RequestMapping(value = "service_ok/{id}")
    public String service_ok(@PathVariable("id") Integer id){
        return "port:" + port +" 线程池:" + Thread.currentThread().getName() + " service_ok,id:" + id;
    }


    /**
     * 服务调用超时，降级处理
     * fallbackMethod:降级处理方法
     * @param id
     * @return
     */
    @RequestMapping(value = "service_timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String service_timeout(@PathVariable("id") Integer id){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " service_ok,id:" + id;
    }


    /**
     * 服务降级处理方法
     * @param id
     * @return
     */
    public String timeoutHandler(Integer id){
        return "port:" +port+" service:hystrix-service-provider-8003 timeout,线程池:" + Thread.currentThread().getName() + " service_timeout,id:" + id;
    }
}
