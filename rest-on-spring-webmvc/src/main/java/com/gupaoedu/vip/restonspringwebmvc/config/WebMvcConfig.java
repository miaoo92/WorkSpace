package com.gupaoedu.vip.restonspringwebmvc.config;

import com.gupaoedu.vip.restonspringwebmvc.http.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.set(0,new MappingJackson2HttpMessageConverter());
        converters.add(new PropertiesPersonHttpMessageConverter());
    }
}
