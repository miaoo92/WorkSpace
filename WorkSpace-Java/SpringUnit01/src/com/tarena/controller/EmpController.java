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
		//查询全部员工
		List<Emp> list = empMapper.findAll();
		//发送到页面
		model.addAttribute("emps", list);
		//指定转发的页面
		return "emp/emp_list";
	}
	
}
