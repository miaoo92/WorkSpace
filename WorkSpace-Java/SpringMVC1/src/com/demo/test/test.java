package com.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.JDBCDataSource;
import com.demo.entity.User;
import com.demo.service.UserService;
import java.util.Properties;


public class test {

	@Test
	public void testUserService() throws Exception{
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		Properties obj = ac.getBean("jdbcProps",Properties.class);
		JDBCDataSource ds = ac.getBean("JDBCDataSource",JDBCDataSource.class);
		System.out.println(obj);
		System.out.println(ds);
		System.out.println(ds.getConnection());
		UserService us = ac.getBean("userService",UserService.class);
		System.out.println(us);
		User user = us.login("0121109320419", "1207620");
		System.out.println(user);
		
		
	}
	
}
