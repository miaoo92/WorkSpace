package web_home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		//服务器端一定要对客户端提供的参数进行参数检查
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//将员工信息插入到数据库
		try{
			Employee e= new Employee();
			e.setName(name);
			e.setSalary(salary);
			e.setAge(age);
			EmployeeDAO add= new EmployeeDAO();
			add.save(e);
			response.sendRedirect("list"); // *****重定向
		} catch (Exception e1) {
			e1.printStackTrace();   //记日志，保留现场
			/*
			 * 看异常能否恢复，如果不能恢复（如果数据库服务暂停，网络中断，
			 * 这种类型的异常称之为系统异常），则提示用户稍后重试。
			 */
			throw new ServletException(e1);
		}
	}
}
