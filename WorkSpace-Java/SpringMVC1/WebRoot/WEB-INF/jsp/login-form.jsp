<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>My JSF 'login-form.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="${base}style.css" />
</head>
  
<body>
	<h6>${message}</h6>
	<form method="post" action="${base}login/login-action1.form">
		<div>
			<h2>登录 login-action1.form</h2>
			<p><label>学号</label><input type="text" name="id"/></p>
			<p><label>密码</label><input type="password" name="campus_card"/></p>
			<h3><input type="submit" value="提交"/></h3>
		</div>
	</form>
	
	<form method="post" action="${base}login/login-action2.form">
		<div>
			<h2>登录 login-action2.form</h2>
			<p><label>学号</label><input type="text" name="id"/></p>
			<p><label>密码</label><input type="password" name="icard"/></p>
			<h3><input type="submit" value="提交"/></h3>
		</div>
	</form>
	
	<form method="post" action="${base}login/login-action3.form">
		<div>
			<h2>登录 login-action3.form</h2>
			<p><label>学号</label><input type="text" name="id"/></p>
			<p><label>密码</label><input type="password" name="campus_card"/></p>
			<h3><input type="submit" value="提交"/></h3>
		</div>
	</form>
	
	<form method="post" action="${base}login/login-action4.form">
		<div>
			<h2>登录 login-action4.form</h2>
			<p><label>学号</label><input type="text" name="id"/></p>
			<p><label>密码</label><input type="password" name="campus_card"/></p>
			<h3><input type="submit" value="提交"/></h3>
		</div>
	</form>
	
	<form method="post" action="${base}login/login-action5.form">
		<div>
			<h2>登录 login-action5.form</h2>
			<p><label>学号</label><input type="text" name="id"/></p>
			<p><label>密码</label><input type="password" name="campus_card"/></p>
			<h3><input type="submit" value="提交"/></h3>
		</div>
	</form>
	
	<form method="post" action="${base}login/login-action6.form">
		<div>
			<h2>登录 login-action6.form</h2>
			<p><label>学号</label><input type="text" name="id" /></p>
			<p><label>密码</label><input type="password" name="campus_card"/></p>
			<h3><input type="submit" value="提交"/></h3>
		</div>
	</form>
	
	
</body>
</html>