package com.imooc.diveinspringboot.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRespository
public @interface SecondLevelRepository {
    String value() default "";
}
