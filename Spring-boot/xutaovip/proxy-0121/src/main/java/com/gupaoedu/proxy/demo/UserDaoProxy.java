package com.gupaoedu.proxy.demo;

public class UserDaoProxy  implements IUserDao{
    private IUserDao userDao;

    public UserDaoProxy(IUserDao userDao) {
        this.userDao = userDao;
    }

    public Integer save(String name) {
        System.out.println("操作前的日志输出。。。。");
        Integer result = userDao.save(name);
        System.out.println("操作后的日志输出。。。。");
        return result;
    }

    public String query(Integer id) {
        System.out.println("操作前的日志输出。。。。");
        userDao.query(1);
        System.out.println("操作后的日志输出。。。。");
        return null;
    }

    public Integer update(String name) {
        return null;
    }
}
