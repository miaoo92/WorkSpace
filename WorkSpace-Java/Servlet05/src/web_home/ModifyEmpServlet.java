package web_home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ModifyEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		Employee e= new Employee();
		e.setId(id);
		e.setAge(age);
		e.setSalary(salary);
		e.setName(name);
		EmployeeDAO dao = new EmployeeDAO();
		try {
			dao.modify(e);
			response.sendRedirect("list");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ServletException(e1);
		}
	}
}
