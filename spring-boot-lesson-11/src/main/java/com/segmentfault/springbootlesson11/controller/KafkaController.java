package com.segmentfault.springbootlesson11.controller;

import com.segmentfault.springbootlesson11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/9
 */
@RestController
public class KafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/message/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("sf-2","0",message);
        return message;
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user){
        kafkaTemplate.send("sf-user" ,"0",user);
        return user;
    }

}
