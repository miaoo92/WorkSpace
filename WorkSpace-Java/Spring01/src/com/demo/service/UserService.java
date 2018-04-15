package com.demo.service;

import com.demo.dao.UserDAO;
import com.demo.entity.User;

public class UserService {
	
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public User login(String id,String campus_card){
		try{
		User user = userDao.findByID(id);
		if(user.getCampus_card().equals(campus_card)){
			return user;
		}
		return null;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
