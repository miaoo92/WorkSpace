package com.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.ExampleBean;
import com.demo.bean.MessageBean;

public class testcase {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");	
	
//	@Test
	public void testMessageBean(){
		MessageBean bean = ac.getBean("messageBean",MessageBean.class); 
		bean.execute();
	}
	
	@Test
	public void testExampleBean(){
		ExampleBean bean1 = ac.getBean("exampleBean",ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean",ExampleBean.class);
		bean1.execute();
		bean2.execute();
	}
	
	@Test
	public void testExampleBean4(){
		ExampleBean bean1 = ac.getBean("exampleBean",ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean",ExampleBean.class);
		System.out.println(bean1 == bean2);
		
	}
}
