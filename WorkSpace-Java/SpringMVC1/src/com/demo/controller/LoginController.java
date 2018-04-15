package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;
import com.demo.service.NameOrPwdException;
import com.demo.service.NullParamException;
import com.demo.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("login.form")
	public String LoginForm(){
		return "login-form";
	}
	
	@RequestMapping("login-action1.form")
	public String checkLogin1(HttpServletRequest req){
		System.out.println("------方法一------");
		String id= req.getParameter("id");
		String campus_card = req.getParameter("campus_card");
		try {
			User user = userService.login(id, campus_card);
			req.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "redirect:login.form";
		} catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "redirect:login.form";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("login-action2.form")
	public String checkLogin2(String id,@RequestParam("icard")String campus_card,HttpServletRequest req){
		System.out.println("------方法二-------");
		try {
			User user = userService.login(id, campus_card);
			req.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("login-action3.form")
	public String checkLogin3(User user,HttpServletRequest req){
		System.out.println("--------方法三-------");
		try {
			User users = userService.login(user.getId(), user.getCampus_card());
			req.getSession().setAttribute("user", users);
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login-form";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("login-action4.form")
	public ModelAndView checkLogin4(String id,String campus_card,HttpServletRequest req){
		System.out.println("----------方法四----------");
		Map<String,Object>  data = new HashMap<String, Object>();
		try {
			User user = userService.login(id, campus_card);
			req.getSession().setAttribute("user", user);
			return new ModelAndView("success",data);
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login-form",data);
		} catch (NullParamException e) {
			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login-form",data);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login-form",data);
		}
	}
	
	@RequestMapping("login-action5.form")
	public String checkLogin5(String id,String campus_card,ModelMap model,HttpServletRequest req){
		System.out.println("---------方法五--------");
		try {
			User user = userService.login(id, campus_card);
			req.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login-form";
		} catch (NullParamException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login-form";
		} catch (Exception e){
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login-form";
		}
	}
	
	@RequestMapping("login-action6.form")
	public String checkLogin6(@ModelAttribute("id")String id,@ModelAttribute("campus_card")String icard,ModelMap model,HttpServletRequest req){
		System.out.println("----------方法六--------");
		try {
			User user = userService.login(id, icard);
			req.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
			return "login-form";
		} catch (NullParamException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login-form";
		} catch (Exception e){
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login-form";
		}
	}
	
}
