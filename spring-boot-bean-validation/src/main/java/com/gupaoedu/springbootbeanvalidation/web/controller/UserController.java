package com.gupaoedu.springbootbeanvalidation.web.controller;


import com.gupaoedu.springbootbeanvalidation.domain.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/user/save")
    public User save(@Valid @RequestBody User user){

        return user;
    }

    @PostMapping("/user/save2")
    public User save2(@RequestBody User user){
        Assert.hasText(user.getName(),"姓名不能为空");
        assert user.getId() <= 10000;
        return user;
    }

}
