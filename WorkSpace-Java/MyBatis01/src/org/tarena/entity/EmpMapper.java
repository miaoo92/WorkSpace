package org.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Emp> {


	public Emp mapRow(ResultSet rs, int rowIndex) throws SQLException {
		
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("EMPNO"));
		emp.setEname(rs.getString("ENAME"));
		emp.setJob(rs.getString("JOB"));
		emp.setMgr(rs.getInt("MGR"));
		emp.setSal(rs.getDouble("SAL"));
		emp.setHiredate(rs.getDate("HIREDATE"));
		emp.setComm(rs.getDouble("COMM"));
		emp.setDeptno(rs.getInt("DEPTNO"));
		
		return emp;
	}

}
