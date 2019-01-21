<%@ page language="java" contentType="text/html;charset=utf-8" import="java.sql.*,Action.*" %>

<!--                        注册验证                                         -->

<!DOCTYPE HTML>
<html>

<head>
	<title>注册验证</title>
</head>

<body>
	
	<%
		Now n = new Now();
		n.setId("U");//只允许注册用户（不能注册管理员）
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("username");
		String pass = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String tele = request.getParameter("tele");
		String mail = request.getParameter("mail");
		boolean flag = n.checkRegi(user,pass,name,tele,mail);//判断是否已经存在用户
	%>
	
	<%
		//判断是否是正确的注册用户
		if (flag == false) {
	%>
			<script>
				alert("用户名已存在!");
				window.document.location.href = "../SignUp.jsp";
			</script>
	<%
		} else if (flag == true) {
	%>
			<script>
				alert("注册成功!");
				window.document.location.href = "../Home.jsp";
			</script>
	<%
		}
	%>
	
</body>

</html>


