package com.itcast.mybatis.mapper;

import com.itcast.mybatis.po.User;
import com.itcast.mybatis.po.UserCustom;
import com.itcast.mybatis.po.UserQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public interface UserMapper {
    /**
     * 添加用户
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id) throws Exception;

    /**
     * 根据用户名模糊查询
     *
     * @param name
     * @return
     * @throws Exception
     */
    public List<User> findUserByName(String name) throws Exception;

    /**
     * 删除用户
     *
     * @param id
     * @throws Exception
     */
    public void deleteUser(int id) throws Exception;

    /**
     * 更新用户
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

    /**
     * 根据userQueryVo条件查询用户
     * 用户信息的综合查询
     *
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    public List<UserCustom> findUserByPara(UserQueryVo userQueryVo) throws Exception;

    /**
     * 根据UserQueryVo条件查询的总记录条数
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;


}
