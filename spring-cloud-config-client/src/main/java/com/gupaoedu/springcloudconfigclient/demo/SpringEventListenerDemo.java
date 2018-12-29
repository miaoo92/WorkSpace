package com.gupaoedu.springcloudconfigclient.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventListenerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册监听器
        applicationContext.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.out.println("得到事件："+event.getSource()+"  @");
            }
        });
        applicationContext.refresh();
        //发布事件
        //监听器得到事件
        applicationContext.publishEvent(new MyApplicationEvent(applicationContext,"hello"));
        applicationContext.publishEvent(new MyApplicationEvent(applicationContext,Integer.valueOf(100)));

    }


    private static class MyApplicationEvent extends ApplicationEvent{

        private final ApplicationContext applicationContext;

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(ApplicationContext applicationContext ,Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }
}
