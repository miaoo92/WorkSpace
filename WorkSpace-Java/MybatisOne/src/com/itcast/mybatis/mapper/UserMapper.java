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
     * ����û�
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * ����id�����û�
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id) throws Exception;

    /**
     * �����û���ģ����ѯ
     *
     * @param name
     * @return
     * @throws Exception
     */
    public List<User> findUserByName(String name) throws Exception;

    /**
     * ɾ���û�
     *
     * @param id
     * @throws Exception
     */
    public void deleteUser(int id) throws Exception;

    /**
     * �����û�
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

    /**
     * ����userQueryVo������ѯ�û�
     * �û���Ϣ���ۺϲ�ѯ
     *
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    public List<UserCustom> findUserByPara(UserQueryVo userQueryVo) throws Exception;

    /**
     * ����UserQueryVo������ѯ���ܼ�¼����
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;


}
