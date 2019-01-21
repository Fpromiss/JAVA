<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,java.io.*,javax.swing.*,Action.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

<title>Cafe_test</title>

<!-- meta -->
<meta charset="UTF-8">

<!-- CSS -->
<link rel="stylesheet" href="CSS/GeneralStyle.css">
<link rel="stylesheet" href="CSS/Management.css">

<!-- JS -->
<script>
	function showAddUserDiv() {
		document.getElementById("add-user-div").style.display = "";
		document.getElementById("add-user-btn-div").style.display = "none";
	}
</script>
<script>
	function hideAddUserDiv() {
		document.getElementById("add-user-div").style.display = "none";
		document.getElementById("add-user-btn-div").style.display = "";
	}
</script>
<script>
	function confirmOption(form) {
		var isConfirmed = confirm("注意：删除后不可恢复，确定要删除吗？");
		if (isConfirmed == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
<script>
	function isValid(form) {
		if (form.username.value == "") {
			alert("用户名不能为空!");
			return false;
		}
		if (form.pwd1.value != form.pwd2.value) {
			alert("两次输入的密码不同!");
			return false;
		} else if (form.pwd1.value == "") {
			alert("用户密码不能为空!");
			return false;
		} else
			return true;
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
					<li><a href="Home.jsp">首页</a></li>
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
					<li id="sign-up"><a href="SignUp.jsp">注册</a></li>
					<%
						} else {
							if (n.getId().equals("U")) {
					%>
					<li id="personal-center"><a href="PersonalCenterOfUser.jsp" class="active">个人中心</a></li>
					<%
						} else {
					%>
					<li id="personal-center"><a href="PersonalCenterOfAdmin.jsp" class="active">个人中心</a></li>
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
				<br />
			</div>
			<div class="info">
				<h1 style="color: #300505;">MANAGEMENT OF USER</h1>
				<h2>你好，管理员！</h2>
			</div>
		</div>
	</header>

	<%
		Now now = new Now();
		now.is_Have();
		ArrayList<Now> allUsers = new ArrayList<Now>();
		allUsers = now.getAllUsers();
	%>

	<div class="allUsers" align="center">
		<br />
		<h1 style="color: white">管理用户</h1>
		<div class="content" align="center">
			<table>
				<tr>
					<th>账号</th>
					<th>姓名</th>
					<th>操作</th>
				</tr>
				<tr>
					<td colspan="3">
						<div id="add-user-div" class="add-user-div"
							style="display: none; margin: 20px;" align="center">
							<form class="add-user-form" method="POST"
								action="Manage_users_jsp/Check_AddNewUser.jsp"
								onSubmit="return isValid(this);">
								<div style="margin-right: 100px;">
									<table class="add-user-table">
										<tr>
											<td>账号：<input type="text" name="username" size="30"></td>
										</tr>
										<tr>
											<td>密码：<input type="password" name="pwd1" size="30"></td>
										</tr>
										<tr>
											<td>确认密码：<input type="password" name="pwd2" size="30"></td>
										</tr>
										<tr>
											<td>姓名：<input type="text" name="name" size="30"></td>
										</tr>
										<tr>
											<td>手机号：<input type="text" name="tele" size="30"></td>
										</tr>
										<tr>
											<td>邮箱：<input type="text" name="mail" size="30"></td>
										</tr>
									</table>
								</div>
								<div style="margin-left: 60px; margin-top: 5px;">
									<input type="submit" class="btn" value="添加" /> <input
										type="button" class="btn" value="取消"
										onclick="hideAddUserDiv()" />
								</div>
							</form>
						</div>
						<div id="add-user-btn-div" class="add-user-btn-div"
							style="display:;">
							<div>
								<input type="button" class="btn" value="添加新用户"
									onclick="showAddUserDiv()" />
							</div>
						</div>
					</td>
				</tr>
				<%
					for (int i = 0; i < allUsers.size(); i++) {
				%>
				<tr>
					<td><%=allUsers.get(i).getUsername()%></td>
					<td><%=allUsers.get(i).getName()%></td>
					<td>
						<div>
							<div style="display: inline-block;">
								<form action="Manage_users_jsp/ModifyUserInfo.jsp" method="post">
									<input type="hidden" name="i" size="20" value=<%=i%> /> <input
										type="submit" class="btn" value="修改" />
								</form>
							</div>
							<div style="display: inline-block;">
								<form method="POST" action="Manage_users_jsp/DeleteUser.jsp"
									onSubmit="return confirmOption(this);">
									<input type="hidden" name="i" size="20" value=<%=i%> /> <input
										type="submit" class="btn" value="删除" />
								</form>
							</div>
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<br />
		<br />
		<br />
	</div>

	<!-- Public Decoration -->
	<div class="blank">
		<div></div>
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


