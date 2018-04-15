package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Emp;

//��Spring������ʼ��ʱ��MapperScannerConfigurer
//��ɨ�����@MyBatisRepository�Ľӿڣ�Ȼ���Զ���
//�����ýӿڵ�ʵ���࣬��ʵ��������࣬�ŵ������С�
@MyBatisRepository
public interface EmpMapper {

	List<Emp> findAll();
	
}
