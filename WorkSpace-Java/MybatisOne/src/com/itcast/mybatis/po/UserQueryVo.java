package com.itcast.mybatis.po;

import java.util.List;

/**
 * @Name UserQueryVo
 * @Discription:��ѯ�����İ�װ��
 * @Author Xutao
 * @Date 2016/3/23.
 */
public class UserQueryVo {

    //�����ﶨ�崫���empno�ļ���
    private List<Integer> empnos;
    //    �������װ����Ҫ�Ĳ�ѯ����
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
