package com.xisen.serviceconsumer9001;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    RestTemplate restTemplate;



    @GetMapping(value = "invoke")
    public String invoke(){

        List<InstanceInfo> instancesByVipAddress = eurekaClient.getInstancesByVipAddress("service-provider", true);
        InstanceInfo instanceInfo = instancesByVipAddress.get(0);
        String hostName = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        String url = "http://" + hostName + ":" + port + "/hello";
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        return resp;
    }

    @GetMapping(value = "lbinvoke")
    public String lbinvoke(){

        String url = "http://service-provider/hello";
        String resp = restTemplate.getForObject(url, String.class);
        return resp;
    }
}
