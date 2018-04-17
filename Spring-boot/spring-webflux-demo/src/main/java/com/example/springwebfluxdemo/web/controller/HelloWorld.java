package com.example.springwebfluxdemo.web.controller;

import com.example.springwebfluxdemo.domain.User;
import com.example.springwebfluxdemo.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Controller
public class HelloWorld {

//    @GetMapping
//    @ResponseBody
//    public Optional<String>  index(){
//        return Optional.of("hello,world");
//    }
    @Autowired
    private UserRespository userRespository;

    @GetMapping
    @ResponseBody
    public Mono<String> index(@RequestParam(required = false) String message){
        return StringUtils.hasText(message)? Mono.just(message):Mono.empty();
    }

    @PostMapping("/user/save")
    @ResponseBody
    public Mono<User> saveUser(@RequestBody User user){
        if(userRespository.saveUser(user)){
            return Mono.just(user);
        }
        return Mono.empty();
    }

    @GetMapping("/user/list")
    @ResponseBody
    public Collection<User> users(){
        return userRespository.findAll();
    }

    @GetMapping("/user/flux")
    @ResponseBody
    public Flux<User> usersList(){
        Collection<User> users = userRespository.findAll();
        Flux<User> flux = Flux.fromIterable(users);
        return flux;
    }

}
