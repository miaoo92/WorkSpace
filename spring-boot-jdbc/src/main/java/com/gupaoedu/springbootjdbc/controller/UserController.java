package com.gupaoedu.springbootjdbc.controller;


import com.gupaoedu.springbootjdbc.domain.User;
import com.gupaoedu.springbootjdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 用户Controller on WebMvc
 */
@RestController
public class UserController {

    private UserRepository userRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/web/mvc/user/save")
    public Boolean save(@RequestBody User user) throws ExecutionException, InterruptedException {
        /*Future<Boolean> future = (Future<Boolean>) executorService.submit(()-> {
            userRepository.save(user);
        });
        return  future.get();*/
        return userRepository.save(user);
    }



}
