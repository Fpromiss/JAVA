<%@ page language="java" contentType="text/html;charset=utf-8" import="java.sql.*,Action.*" %>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
</head>
<body>

	<%
		String i = request.getParameter("i");
		int j = Integer.parseInt(i);
		Now n =new Now();
		n.deleteUser(j);
	%>
	
	<script>
		window.document.location.href = "../ManagementOfUser.jsp";
	</script>

</body>
</html>