package com.demo.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.dao.UserDAO;
import com.demo.entity.User;

@Service
public class UserService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public User login(String id,String campus_card) throws NameOrPwdException,NullParamException{
		if(id == null || id.equals("") || campus_card == null || campus_card.equals("")){
			throw new NullParamException("登陆参数不能为空！");
		}
		User user = userDao.findByID(id);
		if(user != null && user.getCampus_card().equals(campus_card)){
			return user;
		}
		throw new NameOrPwdException("用户名或密码错误！");
	}
	
}
