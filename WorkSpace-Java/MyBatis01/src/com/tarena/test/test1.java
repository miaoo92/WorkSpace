package com.tarena.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.entity.Emp;

import com.tarena.dao.EmpDAO;
import com.tarena.dao.JdbcEmpDAO1;

public class test1 {
	
	public static void main(String[] args) throws Exception{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		EmpDAO empDAO1 = ac.getBean("jdbcEmpDao1",EmpDAO.class);
		List<Emp> list = empDAO1.findAll();
		for(Emp emp:list){
			System.out.println(emp.getEmpno() + " " + emp.getEname());
		}
	}
}
