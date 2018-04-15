package com.itcast.mybatis.po;

import java.util.List;

/**
 * @Name UserQueryVo
 * @Discription:查询条件的包装类
 * @Author Xutao
 * @Date 2016/3/23.
 */
public class UserQueryVo {

    //在这里定义传入的empno的集合
    private List<Integer> empnos;
    //    在这里包装所需要的查询条件
    private UserCustom userCustom;


    public List<Integer> getEmpnos() {
        return empnos;
    }

    public void setEmpnos(List<Integer> empnos) {
        this.empnos = empnos;
    }


    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

}
