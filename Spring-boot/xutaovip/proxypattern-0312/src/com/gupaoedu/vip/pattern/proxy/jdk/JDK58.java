package com.gupaoedu.vip.pattern.proxy.jdk;

import com.gupaoedu.vip.pattern.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDK58 implements InvocationHandler{
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是58，我负责给你找工作，现在已经拿到你的简历");
        System.out.println("开始投递");
        method.invoke(this.target,args);
        System.out.println("开始安排面试");
        return null;
    }

    private Person target;

    public Object getInstance(Person target) throws Exception{
        this.target = target;

        Class<?> clazz = target.getClass();

        return  Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }
}
