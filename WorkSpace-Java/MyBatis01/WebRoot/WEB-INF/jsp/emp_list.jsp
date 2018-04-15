<%@ page language="java" pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>My JSF 'emp-list.jsp' starting page</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>工资</td>
			<td>入职时间</td>
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
			<td>${emp.empno }</td>
			<td>${emp.ename }</td>
			<td>${emp.sal}</td>
			<td>${emp.hiredate }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>