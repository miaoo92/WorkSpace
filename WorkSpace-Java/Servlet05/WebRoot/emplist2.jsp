<%@page pageEncoding="utf-8" contentType="text/html;charsert=utf-8" %>
<%@page import="entity.*,java.util.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@include file="header.jsp"  %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td> ID </td>
							<td> 姓名 </td>
							<td> 薪水 </td>
							<td> 年龄 </td>
							<td> 操作 </td>
						</tr>
						<%
						List<Employee> employees = (List<Employee>)request.getAttribute("employees");
						for(int i=0;i<employees.size();i++){
							Employee emp=employees.get(i);							
							
						%>
						<tr class="row<%=(i%2+1) %>">
							<td>
								<%=emp.getId() %>
							</td>
							<td>
								<%=emp.getName() %>
							</td>
							<td>
								<%=emp.getSalary() %>
							</td>
							<td>
								<%=emp.getAge() %>
							</td>
							<td>
								<a href="del?id=<%=emp.getId() %>" onclick="return confirm('确定删除<%=emp.getName() %>?')">删除</a>&nbsp;
								<a href="load?id=<%=emp.getId() %>">修改</a>
							</td>
						</tr>
						<% } %>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<%@include file="footer.jsp"%>
		</div>
	</body>
</html>
