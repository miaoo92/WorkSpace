package com.gupaoedu.vip.springwebmvc.controller;

import com.gupaoedu.vip.springwebmvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class JSONController {

    @Autowired
    @Qualifier("currentUser")
    private User user;

    @Bean
    public User currentUser(){
        User user = new User();
        user.setAge(20);
        user.setName("JSONS");
        return user;
    }


    @GetMapping(path = "/json/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public User user(){
        user.add(linkTo(methodOn(JSONController.class).setUserName(user.getName())).withSelfRel());
        user.add(linkTo(methodOn(JSONController.class).setUserAge(user.getAge())).withSelfRel());
        return user;
    }

    @GetMapping(path = "/json/user/set/name",produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserName(@RequestParam String name){
        user.setName(name);
        return user;
    }

    @GetMapping(path = "/json/user/set/age",produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserAge(@RequestParam int age){
        user.setAge(age);
        return user;
    }
}
