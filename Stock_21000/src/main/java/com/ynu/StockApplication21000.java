package com.ynu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StockApplication21000 {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication21000.class, args);
    }

}

