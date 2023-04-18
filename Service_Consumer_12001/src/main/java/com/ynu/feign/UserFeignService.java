package com.ynu.feign;

import com.ynu.entity.CommentResult;
import com.ynu.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("provider-server")
public interface UserFeignService {

    @GetMapping("/user/getUserById/{userId}")
    public CommentResult<User> getUserById(@PathVariable("userId") Integer userId);

    @GetMapping("/user/hello")
    public String Hello();
}
