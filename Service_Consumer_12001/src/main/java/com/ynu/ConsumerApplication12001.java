package com.ynu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@LoadBalancerClient(name="provider-server", configuration = CustomLoadBalancedConfig.class)
@EnableFeignClients
public class ConsumerApplication12001 {

//    //2020版开始，没有ribbon了，使用spring-cloud
//    @LoadBalanced
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication12001.class, args);
    }
}
