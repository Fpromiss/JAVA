<%@ page language="java" contentType="text/html;charset=utf-8" import="java.sql.*,Action.*" %>

<!--                        修改用户密码检测                                         -->

<!DOCTYPE HTML>
<html>

<head>
	<title>修改密码</title>
</head>

<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		String oldpass = request.getParameter("oldPwd");
		String newpass = request.getParameter("newPwd1");
		boolean flag = false;
		Now n = new Now();
		n.is_Have();
		flag = n.changePass(oldpass, newpass);
		
		if (n.getId().equals("U")) {
			if (flag == true) {
	%>
				<script>
					alert("修改密码成功!");
					window.document.location.href = "../PersonalCenterOfUser.jsp";
				</script>
	<%
			} else {
	%>
				<script>
					alert("修改密码失败!");
					window.document.location.href = "../PersonalCenterOfUser.jsp";
				</script>
	<%
			}
		} else {
			if (flag == true) {
	%>
				<script>
					alert("修改密码成功!");
					window.document.location.href = "../PersonalCenterOfAdmin.jsp";
				</script>
	<%
			} else {
	%>
				<script>
					alert("修改密码失败!");
					window.document.location.href = "../PersonalCenterOfAdmin.jsp";
				</script>
	<%
			}
		}
	%>
	
</body>

</html>


