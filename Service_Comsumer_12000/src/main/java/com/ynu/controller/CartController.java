package com.ynu.controller;

import com.ynu.entity.CommentResult;
import com.ynu.entity.User;
import com.ynu.feign.UserFeignService;
import com.ynu.loadBalanced.CustomLoadBalancedConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cart")
@LoadBalancerClient(name="provider-server",configuration= CustomLoadBalancedConfig.class)
public class CartController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/hello")
    public String hello(){

//        return restTemplate.getForObject(
//                "http://provider-server/user/hello",
//                String.class
//        );
        return userFeignService.Hello();
    }

    @GetMapping("/addCart/{userId}")
    @CircuitBreaker(name="backendB", fallbackMethod = "fallback")
    public CommentResult<User> addCart(@PathVariable Integer userId) throws InterruptedException{

//        CommentResult<User> result = restTemplate.getForObject(
//                "http://provider-server/user/getUserById/"+userId,
//                CommentResult.class
//        );
        System.out.println("进入方法");
        //Thread.sleep(10000L);//阻塞10s
        CommentResult<User> list = userFeignService.getUserById(userId);
        System.out.println("离开方法");
        return list;
    }

    public CommentResult<User> fallback(Integer userId, Throwable e){
        e.printStackTrace();
        System.out.println("fallback已经调用!");
        CommentResult<User> result = new CommentResult<>(400, "当前用户服务不正常，请稍后再试！", new User());
        return result;
    }

}
