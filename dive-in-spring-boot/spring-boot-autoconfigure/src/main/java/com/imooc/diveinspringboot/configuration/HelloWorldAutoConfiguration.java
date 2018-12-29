package com.imooc.diveinspringboot.configuration;

import com.imooc.diveinspringboot.annotation.EnableHelloWorld;
import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 *
 * @Author miaoo
 * @Date 2018/8/23
 */
@Configuration   //spring模式注解
@EnableHelloWorld   // Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name",value = "miaoo")  //条件装配
public class HelloWorldAutoConfiguration {

}
