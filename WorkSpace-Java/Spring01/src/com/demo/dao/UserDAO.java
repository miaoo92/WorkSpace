package com.demo.dao;

import com.demo.entity.User;

public interface UserDAO {
	
	/**
	 * 根据学生id查找学生
	 * @param id
	 * @return
	 */
	public User findByID(String id);
	
	
}
