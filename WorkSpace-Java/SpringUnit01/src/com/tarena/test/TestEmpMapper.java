package com.tarena.test;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.EmpMapper;
import com.tarena.entity.Emp;

public class TestEmpMapper {
	
	@Test
	public void testFindAll() {
		//1.创建Spring容器
		//1)创建容器中声明的若干个bean，包括
		//DataSource、SqlSessionFactory、
		//MapperScannerConfigurer
		//2)Spring调用MapperScannerConfigurer
		//扫描com.tarena.dao包下带有@MyBatisRepository
		//注解的接口
		//3)Spring会动态的创建该接口的实现类，在这个类
		//中Spring会调用SqlSessionFactory创建Session，
		//关闭session，并且会自动的找到接口对应的映射
		//文件，利用此文件中同名的SQL，来实现对应的方法。
		//4)Spring实例化这个实现类，并放入Spring容器
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		//2.创建EmpMapper接口实例
		//Spring从容器中找到该接口类型的实例，该实例
		//就是上一步Spring实例化并放入容器中的实现类。
		EmpMapper mapper = 
			ctx.getBean(EmpMapper.class);
		//3.调用方法
		List<Emp> list = mapper.findAll();
		for(Emp e : list) {
			System.out.println(
				e.getEmpno() + " " +
				e.getEname() + " " +
				e.getSal() + " " +
				e.getDeptno()
			);
		}
		
	}

}
