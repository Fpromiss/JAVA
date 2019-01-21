<%@ page language="java" contentType="text/html;charset=utf-8" import="java.sql.*,Action.*" %>

<!--                        修改用户信息检测                                         -->

<!DOCTYPE HTML>
<html>

<head>
	<title>修改信息</title>
</head>

<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String tele = request.getParameter("phoneNum");
		String mail = request.getParameter("eMail");
		Now n = new Now();
		n.is_Have();
		n.changeInfo(name, tele, mail);
	%>
	
	<%
		if(n.getId().equals("U")) {
	%>
			<script>
				alert("修改信息成功!");
				window.document.location.href = "../PersonalCenterOfUser.jsp";
			</script>
	<%
		} else {
	%>
			<script>
				alert("修改信息成功!");
				window.document.location.href = "../PersonalCenterOfAdmin.jsp";
			</script>
	<%
		}
	%>
	
</body>

</html>


