package com.gupaoedu.proxy.demo;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
//        IUserDao userDao = new UserDaoImpl();
       /* IUserDao userDao = new UserDaoProxy(new UserDaoImpl());*/

/*       IUserDao userDao = (IUserDao) Proxy.newProxyInstance(IUserDao.class.getClassLoader(),
               new Class[]{IUserDao.class}, new InvocationHandler() {
                   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       System.out.println("操作前的日志输出。。。。");
                       Object result = method.invoke(new UserDaoImpl(),args);
                       System.out.println("操作后的日志输出。。。。");
                       return result;
                   }
               });
        userDao.save("xutao00");
        userDao.query(1);*/
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(IUserDao.class.getClassLoader(),
                new Class[]{IUserDao.class}, new UserDaoHandler());
        byte[] bytes = ProxyGenerator.generateProxyClass("GupaoProxy",new Class[]{IUserDao.class});
        try {
            FileOutputStream fos = new FileOutputStream(new File("GupaoProxy.class"));
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDao.save("xutao01");
    }
}
