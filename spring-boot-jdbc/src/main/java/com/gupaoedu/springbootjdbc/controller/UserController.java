package com.gupaoedu.springbootjdbc.controller;


import com.gupaoedu.springbootjdbc.domain.User;
import com.gupaoedu.springbootjdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户Controller on WebMvc
 */
@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/web/mvc/user/save")
    public Boolean save(@RequestBody User user){
        return  userRepository.save(user);
    }



}
