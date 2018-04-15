<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
	<h1>员工列表</h1>
	<table>
		<tr>
			<td>EMPNO</td>
			<td>ENAME</td>
			<td>JOB</td>
			<td>SAL</td>
			<td>DEPTNO</td>
		</tr>
		<c:forEach items="${emps}" var="e">
			<tr>
				<td>${e.empno }</td>
				<td>${e.ename }</td>
				<td>${e.job }</td>
				<td>${e.sal }</td>
				<td>${e.deptno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>