package com.imooc.diveinspringboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 写点注释吧
 *
 * @Author miaoo
 * @Date 2018/8/23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    String name();

    String value();
}
