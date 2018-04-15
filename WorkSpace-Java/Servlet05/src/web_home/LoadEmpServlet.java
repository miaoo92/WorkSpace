package web_home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class LoadEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		EmployeeDAO dao = new EmployeeDAO();
		try {
			Employee e=dao.findById(id);
			/*
			 * 生成一个修改员工的页面
			 */
			request.setAttribute("e", e);
			request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
