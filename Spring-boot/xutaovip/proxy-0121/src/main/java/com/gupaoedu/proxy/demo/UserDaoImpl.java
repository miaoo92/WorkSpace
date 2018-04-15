package com.gupaoedu.proxy.demo;

public class UserDaoImpl implements IUserDao{
    public Integer save(String name) {
        System.out.println("保存用户数据，name = "+ name);
        return 1;
    }

    public String query(Integer id) {
        System.out.println( "查询用户数据，id = " + id);
        return "查询用户数据，id = " + id;
    }

    public Integer update(String name) {
        System.out.println("更新用户数据，name = "+name);
        return 1;
    }
}
