package com.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.dao.EmpMapper;
import com.tarena.entity.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Resource
	private EmpMapper empMapper;

	@RequestMapping("/findEmp.do")
	public String find(Model model) {
		//��ѯȫ��Ա��
		List<Emp> list = empMapper.findAll();
		//���͵�ҳ��
		model.addAttribute("emps", list);
		//ָ��ת����ҳ��
		return "emp/emp_list";
	}
	
}
