package com.imooc.application.aop;

/**
 * TODO
 *
 * @Author miaoo
 * @Date 2018/9/4
 */
public class Main {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        IUserDao proxy = (IUserDao) new UserDao.MyProxyFactory(userDao).getProxyInstance();
        proxy.save();
    }



}
