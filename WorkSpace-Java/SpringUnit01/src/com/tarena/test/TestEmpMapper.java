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
		//1.����Spring����
		//1)�������������������ɸ�bean������
		//DataSource��SqlSessionFactory��
		//MapperScannerConfigurer
		//2)Spring����MapperScannerConfigurer
		//ɨ��com.tarena.dao���´���@MyBatisRepository
		//ע��Ľӿ�
		//3)Spring�ᶯ̬�Ĵ����ýӿڵ�ʵ���࣬�������
		//��Spring�����SqlSessionFactory����Session��
		//�ر�session�����һ��Զ����ҵ��ӿڶ�Ӧ��ӳ��
		//�ļ������ô��ļ���ͬ����SQL����ʵ�ֶ�Ӧ�ķ�����
		//4)Springʵ�������ʵ���࣬������Spring����
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		//2.����EmpMapper�ӿ�ʵ��
		//Spring���������ҵ��ýӿ����͵�ʵ������ʵ��
		//������һ��Springʵ���������������е�ʵ���ࡣ
		EmpMapper mapper = 
			ctx.getBean(EmpMapper.class);
		//3.���÷���
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
