<%@ page language="java" contentType="text/html;charset=utf-8" import="java.sql.*,Action.*,java.util.*" %>

<!--                        修改用户                                         -->

<!DOCTYPE HTML>
<html>
<head>
	<title>修改用户</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		String i = request.getParameter("i");

		String name = request.getParameter("name");
		String tele = request.getParameter("phoneNum");
		String mail = request.getParameter("eMail");
		int j = Integer.parseInt(i);
		Now n = new Now();
		n.changeUser(j, name, tele, mail);
	%>
	
	<script>
		window.document.location.href = "../ManagementOfUser.jsp";
	</script>
	
</body>
</html>


