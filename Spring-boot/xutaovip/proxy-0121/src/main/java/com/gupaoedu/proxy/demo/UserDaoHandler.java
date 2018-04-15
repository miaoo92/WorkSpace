package com.gupaoedu.proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserDaoHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前的日志输出。。。。");
        Object result = method.invoke(new UserDaoImpl(),args);
        System.out.println("操作后的日志输出。。。。");
        return result;
    }
}
