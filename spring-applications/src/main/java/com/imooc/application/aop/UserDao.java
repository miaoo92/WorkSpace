package com.imooc.application.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/9/4
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("模拟：保存用户");
    }

    @Override
    public void find() {
        System.out.println("模拟：查找用户");
    }

    static class MyProxyFactory{
        private Object target;

        public MyProxyFactory(Object target) {
            this.target = target;
        }

        public Object getProxyInstance() {
            Object proxyInstance = Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    (Object proxy, Method method, Object[] args)->{
                        System.out.println("方法执行前");
                        Object result = method.invoke(target,args);
                        System.out.println("方法执行后");
                        return result;
                    });
            return proxyInstance;
        }
    }

}
