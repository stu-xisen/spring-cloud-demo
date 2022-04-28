package serviceprovider8002;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {


    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient eurekaClient;



    @Value("${server.port}")
    String port;


    @GetMapping("hello")
    public String hello(){
        return "hello from port " + port;
    }

    @RequestMapping("hello2")
    public String hello2(@RequestBody String name){
        return "hello " + name + " from port " + port;
    }


    @GetMapping("servicesInfo")
    public Object servicesInfo(){

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
