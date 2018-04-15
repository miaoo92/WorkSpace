package com.tarena.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tarena.entity.Emp;

import com.tarena.dao.EmpDAO;

@Controller
@RequestMapping("/emp")
public class EmpListController {

	private EmpDAO dao;
	@Autowired
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	@RequestMapping("/list.do")
	public ModelAndView execute(Model model){
		List<Emp> list = dao.findAll();
		for(Emp e:list){
			System.out.println(e.getEmpno()+"   "+e.getEname());
		} 
		ModelAndView  modelandview = new ModelAndView();
		modelandview.addObject("emps",list);
		modelandview.setViewName("/WEB-INF/jsp/emp_list.jsp");
		return modelandview;
	}
	
	
}
