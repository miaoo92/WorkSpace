package web_home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>");
			out.println("</head>");
			out.println("<table border='1' width=60% cellspacing='0'>");
			out.println("<tr><td>id</td><td>姓名</td><td>salary</td><td>年龄</td><td></td></tr>");
			for(int i=0;i<employees.size();i++){
				Employee e=employees.get(i);
				int id=e.getId();
				String name=e.getName();
				double salary=e.getSalary();
				int age =e.getAge();
				out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+salary+"</td>"+
						"<td>"+age+"</td><td><a href='del?id="+id+"'>删除</a>&nbsp;&nbsp;"+
						"&nbsp;&nbsp;&nbsp;<a href='load?id="+id+"'>修改</a></td></tr>");
			}
			out.println("</table>");
			out.println("<a href='addEmp.html'>添加新员工a</a>");
			out.println("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();   //记日志，保留现场
			/*
			 * 看异常能否恢复，如果不能恢复（如果数据库服务暂停，网络中断，
			 * 这种类型的异常称之为系统异常），则提示用户稍后重试。
			 */
			out.println("系统繁忙，请稍后重试");
		} 
	}
}
