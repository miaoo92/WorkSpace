package com.imooc.diveinspringboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloworldConfiguration {

    @Bean
    public String helloWorld(){  //方法名即Bean的名称
        return "hello,world 2018";
    }

}
