<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<div id="header">
	<div id="rightheader">
		<p>
			<% Date now = new Date();
				SimpleDateFormat dd= new SimpleDateFormat("yyyy/MM/dd");
			%>
			<%=dd.format(now) %>
			<br />
		</p>
	</div>
	<div id="topheader">
		<h1 id="title">
			<a href="#">main</a>
		</h1>
	</div>
	<div id="navigation">
	</div>
</div>