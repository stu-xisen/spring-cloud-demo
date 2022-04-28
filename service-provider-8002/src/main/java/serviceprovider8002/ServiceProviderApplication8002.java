package serviceprovider8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProviderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication8002.class,args);
    }
}
