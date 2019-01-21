<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,java.io.*,javax.swing.*,Action.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

<title>杨超越的咖啡厅</title>

<!-- meta -->
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="CSS/GeneralStyle.css">
<link rel="stylesheet" href="CSS/SignUpAndLogIn.css">

<!-- js -->
<script>
	function isValid(form) {
		if (form.username.value == "") {
			alert("请输入用户名！");
			return false;
		} else if (form.pwd1.value == "") {
			alert("请设置密码！");
			return false;
		} else if (form.pwd1.value != form.pwd2.value) {
			alert("密码不一致！");
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body>

	<%
		Now n = new Now();
		n.is_Have();
	%>

	<!-- Public Navigation Bar -->
	<nav>
		<div class="bar">
			<div class="logo">
				<h1>
					<a href="Home.jsp">YCYCafe</a>
				</h1>
			</div>
			<div class="options">
				<ul>
					<li><a href="Home.jsp" >首页</a></li>
					<%
						if (n.getId().equals("U")) {
					%>
					<li><a href="Menu.jsp">菜单</a></li>
					<%
						} else {
					%>
					<li><a href="ManagementOfMenu.jsp">菜单</a></li>
					<%
						}
					%>
					<%
						if (!n.is_Have()) {
					%>
					<li id="log-in"><a href="LogIn.jsp">登录</a></li>
					<li id="sign-up"><a href="SignUp.jsp" class="active">注册</a></li>
					<%
						} else {
							if (n.getId().equals("U")) {
					%>
					<li id="personal-center"><a href="PersonalCenterOfUser.jsp">个人中心</a></li>
					<%
						} else {
					%>
					<li id="personal-center"><a href="PersonalCenterOfAdmin.jsp">个人中心</a></li>
					<%
						}
					%>
					<li id="log-out"><a onclick="logOut()" href="LogOut.jsp">退出登录</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>


	<!-- Decorative and Public Header: Logo | Info -->
	<header class="header">
		<div class="display" align="center">
			<div>
				<br />
				<br />
				<br />
			</div>
			<div class="info">
				<h1 style="color: #300505;">SIGN UP</h1>
				<h2>成为超越用户，纵享超越特权</h2>
			</div>
		</div>
	</header>

	<!--  -->
	<div class="input-info">
		<div class="display">
			<div>
				<div>
					<img src="images/logo.png" alt="YCYCafe_Logo" width="450"
						height="450" style="margin-top: 0px" />
				</div>
			</div>
			<div>
				<div class="sign-up-form">
					<form id="sign-up-form" method="POST"
						action="Manage_users_jsp/Check_SignUpAccount.jsp"
						onSubmit="return isValid(this);">
						<br />Username: <br />
						<input type="text" name="username" size="40"> <br />Password:
						<br />
						<input type="password" name="pwd1" size="40"> <br />Re-enter
						the password: <br />
						<input type="password" name="pwd2" size="40"> <br />Name:
						<br />
						<input type="text" name="name" size="40"> <br />Telephone:
						<br />
						<input type="text" name="tele" size="40"> <br />Email: <br />
						<input type="text" name="mail" size="40"> <br />
						<br />
						<input type="submit" class="btn" value="Sign up" /><br />
						<br />
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Decorative and Public Footer: Info -->
	<footer class="footer">
		<br />
		<div class="content">
			<div class="links" align="center">
				<h4 style="color: white;">LINKS</h4>
				<p>
					<a href="#">返回顶部</a>
				</p>
				<p>
					<a href="Home.jsp">首页</a>
				</p>
				<p>
					<a href="Menu.jsp">菜单</a>
				</p>
				<p>
					<a href="">近期活动</a>
				</p>
				<p>
					<a href="">VIP俱乐部</a>
				</p>
			</div>
			<div class="info" align="center">
				<div>
					<p style="color: white;">商务合作请联系：+86-136-6606-3075</p>
				</div>
				<div>
					<h4 style="margin-bottom: 0px;">杨超越组成员介绍</h4>
					<p style="margin-top: 0px;">邱学良&ensp;|&ensp;严学焕&ensp;|&ensp;洪启武&ensp;|&ensp;方俊&ensp;|&ensp;黄振闽</p>
				</div>
			</div>
		</div>
		<div align="center">
			<div class="content" align="center"
				style="border-top: 1px solid #666666; width: 80%;">
				<p>Copyright &copy; Xueliang Qiu 2018. All rights reserved.</p>
			</div>
		</div>
	</footer>
	<hr />

</body>
</html>


