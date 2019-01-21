<%@ page language="java" import="java.sql.*,Action.*" contentType="text/html;charset=utf-8"%>

<!--                       添加用户                                      -->

<!DOCTYPE HTML>
<html>

<head>
	<title>添加用户</title>
</head>
<body>
	
	<%
		Now n = new Now();
		n.setId("A");//只允许注册用户,A只是用来传参判断
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
				alert("该用户名已存在，注册失败!");
				window.document.location.href = "../ManagementOfUser.jsp";
			</script>
	<%
		} else {
	%>
			<script>
				alert("注册成功!");
				window.document.location.href = "../ManagementOfUser.jsp";
			</script>
	<%
		}
	%>
	
</body>
</html>


