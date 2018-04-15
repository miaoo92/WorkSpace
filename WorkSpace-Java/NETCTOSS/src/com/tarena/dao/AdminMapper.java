package com.tarena.dao;

import java.util.List;
import java.util.Map;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Admin;
import com.tarena.entity.Module;
import com.tarena.entity.page.AdminPage;

@MyBatisRepository
public interface AdminMapper {
	
	List<Admin> findByPage(AdminPage page);
	
	int findRows();
	
	void updatePassword(Map<String,Object> param);
	
	List<Module> selectAllModules();
	
	void insertAdmin(Admin admin);
	
	void deleteAdmin(int id);
	
	void deleteARByAdminId(int id);
	
	Admin findByCode(String id);
	
	List<Module> findModuleByAdmin(Integer adminId);
}
