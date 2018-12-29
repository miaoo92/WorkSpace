package com.imooc.web.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Spring Web MVC配置类
 *
 * @author miaoo
 * @since 2018/9/13
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        return resolver;
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer(){
        return (factory -> {
            factory.addContextCustomizers((context -> {
                //相对于E:\WorkSpace\dive-in-spring-boot
                String relativePath = "springboot-view/src/main/webapp";
                File docBase = new  File(relativePath);
                if (docBase.exists()){
                    context.setDocBase(docBase.getAbsolutePath());
                }
            }));
        });
    }

    private static volatile int count = 0;

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            Thread a = new Thread(){
                public void run(){
                    for (int i=0;i<2;i++){
                        try {
                            TimeUnit.MICROSECONDS.sleep(50);
                            count++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(count+(count!=10?",":""));
                    }
                }
            };
            a.start();
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
