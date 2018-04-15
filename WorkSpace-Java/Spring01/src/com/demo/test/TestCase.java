package com.demo.test;

import java.sql.Connection;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.ExampleBean;
import com.demo.dao.JDBCDataSource;
import com.demo.dao.UserDAO;
import com.demo.entity.User;
import com.demo.service.UserService;

public class TestCase {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	AbstractApplicationContext ctx = (AbstractApplicationContext)ac;

//	@Test
	public void testCreatBeanObject1(){
		
		Calendar cal1 = ac.getBean("calendarObj1",Calendar.class);
		System.out.println("cal1"+ cal1);
	}
	
//	@Test
	public void testCreatBeanObject2(){
		Calendar cal2 = ac.getBean("calendarObj2", Calendar.class);
		System.out.println("cal2:  " + cal2);
	}
	
//	@Test
	public void testCreatBeanObject3(){
		Calendar cal3 = ac.getBean("calendarObj3", Calendar.class);
		System.out.println("cal3:  "+ cal3);
		ctx.close();
	}
	
//	@Test
	public void testExampleBean(){
		ExampleBean bean1 = ac.getBean("exampleBean",ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean1 == bean2);
		ctx.close();
	}
	
//	@Test
	public void testJDBCDataSource() throws Exception{
		UserDAO userdao = ac.getBean("UserDAO",UserDAO.class);
		User user = userdao.findByID("0121109320421");
		System.out.println(user);
	}
	
	@Test
	public void testUserService(){
		UserService userService = ac.getBean("userService",UserService.class);
		User user = userService.login("0121109320421", "1207620");
		System.out.println(user);
		
		
	}
	
}
