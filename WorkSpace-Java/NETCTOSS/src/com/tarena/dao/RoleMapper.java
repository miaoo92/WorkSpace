package com.tarena.dao;

import java.util.List;
import java.util.Map;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Module;
import com.tarena.entity.Role;
import com.tarena.entity.page.RolePage;

@MyBatisRepository
public interface RoleMapper {

	List<Role> findByPage(RolePage page);
	
	int findRows();
	
	List<Module> findAllModule();
	
	void save(Role role);
	 
	void saveRoleModule(Map<String,Object> param);
	
	Role findByName(String name);
	
	Role findById(int id);
	
	void update(Role role);
	
	void deleteRoleModule(int roleId);
	
	void deleteRole(int roleId);
}
