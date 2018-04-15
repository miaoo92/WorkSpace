package com.gupaoedu.proxy.demo;

public interface IUserDao {

    public Integer save(String name);

    public String query(Integer id);

    public Integer update(String name);
}
