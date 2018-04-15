package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Emp;

//在Spring容器初始化时，MapperScannerConfigurer
//会扫描带有@MyBatisRepository的接口，然后自动的
//创建该接口的实现类，并实例化这个类，放到容器中。
@MyBatisRepository
public interface EmpMapper {

	List<Emp> findAll();
	
}
