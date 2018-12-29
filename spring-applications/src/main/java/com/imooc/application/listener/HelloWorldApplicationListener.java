package com.imooc.application.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * TODO
 *
 * @Author miaoo
 * @Date 2018/8/28
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Hello world:"+ contextRefreshedEvent.getApplicationContext().getId()
            +",timestamp: "+contextRefreshedEvent.getTimestamp());
    }
}
