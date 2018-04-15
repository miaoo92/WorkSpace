package com.itcast.mybatis.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/1/5.
 **/
public class User implements Serializable {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    private int deptno;

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public int getMgr() {
        return mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public int getDeptno() {
        return deptno;
    }

    @Override
    public String toString() {
        return "User{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", deptno=" + deptno +
                '}';
    }
}
