package com.udea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class MicroserviceClientgreetingApplication {

    public static final String SERVICE_URL = "http://MICROSERVICE-GREETING";

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceClientgreetingApplication.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ClientGreetingService helloWorldService() {
        return new ClientGreetingService(SERVICE_URL);
    }

    @Bean
    public ClientGreetingController helloWorldController() {
        return new ClientGreetingController(helloWorldService());
    }

    @Bean
    public ClientGreetingHomeController homeController() {
        return new ClientGreetingHomeController();
    }
}
