package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.entity.User;

public class mysqlUserDAO implements UserDAO {

	private JDBCDataSource dataSource;
	
	public mysqlUserDAO(JDBCDataSource dataSource){
		this.dataSource = dataSource;
	}

	public  User findByID(String id) {
		String sql = "select id,name,phone,campus_card from student where id=?";
		Connection conn = null;
		User user = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setCampus_card(rs.getString("campus_card"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataSource.close(conn);
		}
		return user;
	}
	

}
