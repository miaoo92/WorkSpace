<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
	<head></head>
	<body>
		<%  
		String msg=(String)request.getAttribute("error");
		%>
		<%=msg %>
	</body>
</html>