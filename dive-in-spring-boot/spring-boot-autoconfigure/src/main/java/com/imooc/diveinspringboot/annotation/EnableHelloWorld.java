package com.imooc.diveinspringboot.annotation;

import com.imooc.diveinspringboot.configuration.HelloworldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloworldConfiguration.class)
//@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
