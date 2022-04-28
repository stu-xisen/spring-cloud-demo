package com.xisen.serviceprovider8001;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {


    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    MyService myService;


    @Value("${server.port}")
    String port;


    @GetMapping("hello")
    public String hello(){
        String res = "hello from port " + port;
        res += " " + myService.hello();
        return res;
    }

    @GetMapping("hello2")
    public String hello2(String name){
        String res = "hello "+ name +" from port " + port;

        res += " " + myService.hello2(name);

        return res;
    }


    @GetMapping("hello3/{name}")
    public String hello3(@PathVariable("name") String name){
        String res = "hello3 "+ name +" from port " + port;
        return res;
    }

    @GetMapping("servicesInfo")
    public List<InstanceInfo> servicesInfo(){

        List<String> services = client.getServices();

        List<ServiceInstance> instances = client.getInstances("service-provider");
        for (ServiceInstance instance : instances) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }

        List<InstanceInfo> instancesByVipAddress = eurekaClient.getInstancesByVipAddress("service-provider", true);
        for (InstanceInfo instanceInfo : instancesByVipAddress) {
            String hostName = instanceInfo.getHostName();
            int port = instanceInfo.getPort();
            String url = "http://" + hostName + ":" + port;
            System.out.println(url);
        }

        return instancesByVipAddress;
    }



}
