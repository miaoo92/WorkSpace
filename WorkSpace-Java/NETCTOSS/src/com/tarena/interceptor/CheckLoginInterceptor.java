package com.tarena.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tarena.entity.Admin;

public class CheckLoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		//从session中读取用户信息
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		if(admin == null) {
			response.sendRedirect(request.getContextPath()+"/login/toLogin.do");
			return false;
		}else{
			return true;
		}
	}

}
