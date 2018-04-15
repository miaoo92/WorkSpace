package com.gupaoedu.vip.pattern.proxy.jdk;

import com.gupaoedu.vip.pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeiPo implements InvocationHandler{
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，我负责给你找对象，现在已经拿到你的需求了");
        System.out.println("开始物色");
        method.invoke(this.target,args);
        System.out.println("如果合适的话，就开始办事");
        return null;
    }

    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();

        return  Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }
}
