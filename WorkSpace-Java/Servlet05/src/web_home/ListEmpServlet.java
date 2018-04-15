package web_home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ListEmpServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		try {
			EmployeeDAO dao=new EmployeeDAO();
			List<Employee> employees=dao.findAll();
			request.setAttribute("employees", employees);
			RequestDispatcher rd = request.getRequestDispatcher("emplist2.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();   //记日志，保留现场
			/*
			 * 看异常能否恢复，如果不能恢复（如果数据库服务暂停，网络中断，
			 * 这种类型的异常称之为系统异常），则提示用户稍后重试。
			 */
//			request.setAttribute("error", "系统繁忙，请稍后重试");
//			request.getRequestDispatcher("error.jsp").forward(request, response);
			throw new ServletException(e);
		} 
	}
}
