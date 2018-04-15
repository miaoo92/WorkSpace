package com.tarena.dao;

import java.util.List;
import java.util.Map;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Service;
import com.tarena.entity.page.ServicePage;

@MyBatisRepository
public interface ServiceMapper {
	
	List<Map<String,Object>> findByPage(ServicePage page);
	int findRows(ServicePage page);
	void start(Integer id);
	void pause(Integer id);
	void delete(Integer id);
	Service findById(Integer id);
	void pauseByAccountId(Integer accountId);
	
}
