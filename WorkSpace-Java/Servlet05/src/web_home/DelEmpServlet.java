package web_home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class DelEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		try {
			EmployeeDAO deldao=new EmployeeDAO();
			deldao.del(Integer.parseInt(id));
			response.sendRedirect("list"); // *****重定向
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
