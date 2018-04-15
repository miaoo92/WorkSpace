package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.CostMapper;
import com.tarena.entity.Cost;

public class TestCase {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//	@Test
	public  void testFindAll(){}
	@Test
	public void testFindById(){
		CostMapper mapper = ctx.getBean(CostMapper.class);
		Cost c = mapper.findById(1);
		System.out.println(c.getName()+c.getCost_id());
		
	}
}
