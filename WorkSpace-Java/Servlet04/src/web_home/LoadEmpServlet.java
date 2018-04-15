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
			 out.println("<form action='modify' method='post'>");
			 out.println("ID:"+id+"<br/>");
			 out.println("姓名：<input name='name' value='"+e.getName()+"' /><br />");
			 out.println("薪水：<input name='salary' value='"+e.getSalary()+"'/><br />");
			 out.println("年龄：<input name='age' value='"+e.getAge()+"'/><br />");
			 out.println("<input type='hidden' name='id' value='"+id+"'>");
			 out.println("<input type='submit' value='提交'/>");
			 out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙！");
		}
		
	}
}
