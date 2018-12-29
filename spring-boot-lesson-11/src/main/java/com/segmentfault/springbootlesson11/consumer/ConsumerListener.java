package com.segmentfault.springbootlesson11.consumer;

import com.segmentfault.springbootlesson11.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/9
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "sf-2")
    public void consumer(String message){
        System.out.println(message);
    }

    @KafkaListener(topics = "sf-user")
    public void consumer(User user){
        System.out.println(user);
    }
}
