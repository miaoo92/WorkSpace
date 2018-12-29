package com.imooc.application.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * TODO
 *
 * @Author miaoo
 * @Date 2018/8/28
 */
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer,Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("After ConfigurableApplicationContext.id = "+configurableApplicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+1;
    }
}
