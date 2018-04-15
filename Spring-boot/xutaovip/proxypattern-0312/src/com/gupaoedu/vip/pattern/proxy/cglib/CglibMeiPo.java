package com.gupaoedu.vip.pattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeiPo  implements MethodInterceptor{

    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        //要把哪个类设置为即将生成的新类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("我是媒婆，我负责给你找对象，现在已经拿到你的需求了");
        System.out.println("开始物色");
        //业务的增强
        methodProxy.invokeSuper(o,objects);
        System.out.println("如果合适的话，就开始约会");

        return null;
    }
}
