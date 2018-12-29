package com.imooc.spring.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/9/10
 */
@ComponentScan(basePackages = "com.imooc.spring.web.servlet.controller")
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                getClass()      //返回当前类
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
