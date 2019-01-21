<%@ page language="java" contentType="text/html;charset=utf-8" import="java.sql.*,Action.*" %>

<!--                        登录验证                                         -->

<!DOCTYPE HTML>
<html>

<head>
	<title>登录验证</title>
</head>

<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String chk;
		chk = request.getParameter("type");
		Now n = new Now();
		
		//判断是用户还是管理员
		if (chk.equals("user")) {
			n.setId("U");
		} else if (chk.equals("admin")) {
			n.setId("A");
		} else {
			//默认是user
			n.setId("U");
		}
	%>
	
	<%
		//判断是否是正确的登录用户
		if (n.checkPass(user, pwd)) {
	%>
			<script>
				alert("登录成功!");
				window.document.location.href = "../Home.jsp";
			</script>
	<%
		} else {
	%>
			<script>
				alert("请输入正确的用户名和密码!");
				window.document.location.href = "../LogIn.jsp";
			</script>
	<%
		}
	%>
	
</body>

</html>


