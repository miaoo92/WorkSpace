package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MyBatisRepository;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;

@MyBatisRepository
public interface AccountMapper {
	
	List<Account> findByPage(AccountPage page);
	int findRows(AccountPage page);
	void pause(int id);
	void start(int id);
	void delete(int id);
	Account findById(int id);
	Account findByIdcardNo(String idcardNo);
}
