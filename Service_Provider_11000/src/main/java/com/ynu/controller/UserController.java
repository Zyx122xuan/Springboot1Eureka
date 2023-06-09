package com.ynu.controller;

import com.ynu.entity.CommentResult;
import com.ynu.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    @GetMapping("/getUserById/{userId}")
    public CommentResult<User> getUserById(@PathVariable Integer userId){
        User u = new User(userId,"小明","123456");
        return new CommentResult<>(200,"success(11000)",u);
    }
}
