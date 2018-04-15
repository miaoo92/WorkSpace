package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Employee;

public class EmployeeDAO {
	
	public void modify(Employee e) throws Exception{
		Connection conn=null;
		PreparedStatement prep=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("update emp set name=?,salary=?,age=? where id=?");
			prep.setString(1, e.getName());
			prep.setDouble(2, e.getSalary());
			prep.setInt(3, e.getAge());
			prep.setInt(4, e.getId());
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	public Employee findById(int id) throws Exception{
		Employee e=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("select * from emp where id=?");
			prep.setInt(1, id);
			rs=prep.executeQuery();
			if(rs.next()){
				e=new Employee();
				e.setId(id);
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}
		return e;
	}
	
	public void del(int id) throws Exception{
		Connection conn=null;
		PreparedStatement prep=null;
		try {
			conn=DBUtil.getConnection();
//			pre=conn.prepareStatement("delete from emp where id=?");
			prep=conn.prepareStatement("delete from emp where id=?");
			prep.setInt(1, id);
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		} finally{
			DBUtil.close(conn);
		}
		
	}
	
	
	public void save(Employee e) throws Exception{
		Connection conn=null;
		PreparedStatement prep=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("insert into emp(name,salary,age) values (?,?,?)");
			prep.setString(1, e.getName());
			prep.setDouble(2, e.getSalary());
			prep.setInt(3, e.getAge());
			prep.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		} finally{
			DBUtil.close(conn);
		}
	}
	
	
	public List<Employee> findAll() throws Exception{
		List<Employee> employees=new ArrayList<Employee>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rst=null;
		try {
			conn=DBUtil.getConnection();
			prep=conn.prepareStatement("select * from emp order by id");
			rst=prep.executeQuery();
			while(rst.next()){
				int id=rst.getInt("id");
				String name=rst.getString("name");
				double salary=rst.getDouble("salary");
				int age = rst.getInt("age");
				Employee e= new Employee();
					e.setId(id);
					e.setName(name);
					e.setSalary(salary);
					e.setAge(age);
				employees.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtil.close(conn);
		}
		
		return employees;
	}
}
