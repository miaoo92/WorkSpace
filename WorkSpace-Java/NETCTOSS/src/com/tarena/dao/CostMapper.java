package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Cost;
import com.tarena.entity.page.CostPage;

@MyBatisRepository
public interface CostMapper {
	
	List<Cost> findAll();
	List<Cost> findByPage(CostPage page);
	int findRows();
	
	void save(Cost cost);
	Cost findById(Integer cost_id);
	void update(Cost cost);
	void delete(Integer cost_id);
	
}
