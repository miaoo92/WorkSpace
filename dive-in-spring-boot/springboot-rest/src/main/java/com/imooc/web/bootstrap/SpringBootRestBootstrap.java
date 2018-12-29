package com.imooc.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/9/18
 */
@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootRestBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class,args);
    }
}
