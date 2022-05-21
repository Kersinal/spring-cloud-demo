package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCloudProviderDept8002Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProviderDept8002Application.class,args);
    }
}
