package com.tarena.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.tarena.entity.Emp;
import org.tarena.entity.EmpMapper;

public class JdbcEmpDAO1 extends JdbcDaoSupport implements EmpDAO {

	public void delete(int no) {
		String sql = "delete from emp_test where empno=?";
		Object[] params = {no};
		super.getJdbcTemplate().update(sql,params);
	}

	public List<Emp> findAll() {
		String sql = "select * from emp_test";
		RowMapper<Emp> mapper = new EmpMapper();
		List<Emp> list = super.getJdbcTemplate().query(sql,mapper);
		return list;
	}

	public Emp findByNo(int no) {
		String sql = "select * from emp_test where EMPNO=?";
		Object[] params = {no};
		RowMapper<Emp> mapper = new EmpMapper();
		Emp emp = super.getJdbcTemplate().queryForObject(sql, params,mapper);
		return emp;
	}

	public void save(Emp emp) {
		String sql = "insert into emp_test (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) value (?,?,?,?,?,?,?,?)";
		Object[] params = {emp.getEmpno(),
									  emp.getEname(),
									  emp.getJob(),
									  emp.getMgr(),
									  emp.getHiredate(),
									  emp.getSal(),
									  emp.getComm(),
									  emp.getDeptno()
									};
		super.getJdbcTemplate().update(sql,params);

	}

	public void update(Emp emp) {
		String sql = "update emp_test set ENAME=?,JOB=?,MGR=?,HIREDATE=?,SAL=?,COMM=?,DEPTNO=? where EMPNO=?";
		Object[] params = {emp.getEname(),
									  emp.getJob(),
									  emp.getMgr(),
									  emp.getHiredate(),
									  emp.getSal(),
									  emp.getComm(),
									  emp.getDeptno(),
									  emp.getEmpno()
									};
		super.getJdbcTemplate().update(sql,params);
		

	}

}
