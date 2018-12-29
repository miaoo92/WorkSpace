package com.imooc.application;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @Author miaoo
 * @Date 2018/8/29
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.addApplicationListener(event -> {
            System.out.println("监听到事件" + event);
        });
        context.refresh();
        context.publishEvent("Hello World");
        context.publishEvent("2018");
        context.publishEvent(new ApplicationEvent("小马哥") {
        });

        context.close();
    }
}
