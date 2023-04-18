package com.ynu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication22000 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication22000.class, args);
    }

}

