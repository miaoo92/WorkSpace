package com.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.Controller;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class TestCase {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
	
	/**
	 * handlerMapping映射测试
	 */
	@Test
	public void testHandlerMapping(){
		HandlerMapping obj = ac.getBean("handlerMapping",HandlerMapping.class);
		Properties map = ac.getBean("urlMappings",Properties.class);
		System.out.println(obj);
		System.out.println(map);
	}
	
	@Test
	public void testHelloController(){
		Controller obj = ac.getBean("helloController",Controller.class);
		System.out.println(obj);
	}
	
}
