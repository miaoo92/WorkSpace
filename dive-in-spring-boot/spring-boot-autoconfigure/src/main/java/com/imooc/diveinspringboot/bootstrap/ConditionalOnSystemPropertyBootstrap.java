package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件装配引导类
 *
 * @Author miaoo
 * @Date 2018/8/23
 */

public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "miaoo")
    public String helloWorld(){
        return "hello,world,miaoo";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext  context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String hello = context.getBean("helloWorld",String.class);
        System.out.println(hello);
        context.close();
    }
}
