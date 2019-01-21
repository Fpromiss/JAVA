<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,java.io.*,javax.swing.*,Action.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

<title>杨超越的咖啡厅</title>

<!-- meta -->
<meta charset="UTF-8">

<!-- CSS -->
<link rel="stylesheet" href="CSS/GeneralStyle.css">
<link rel="stylesheet" href="CSS/PersonalCenter.css">

<!-- JS -->
<script type="text/javascript" src="JS/PersonalCenter_Modify.js"></script>

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
					<li id="personal-center"><a href="PersonalCenterOfUser.jsp"
						class="active">个人中心</a></li>
					<%
						} else {
					%>
					<li id="personal-center"><a href="PersonalCenterOfAdmin.jsp"
						class="active">个人中心</a></li>
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
				<br /> <br /> <br /> <br />
			</div>
			<div class="info">
				<h1 style="color: #300505;">PERSONAL CENTER</h1>
				<h2>独特品味，超越把握</h2>
			</div>
		</div>
	</header>

	<div class="greeting">
		<p>
			你好，<span style="color: #da171d;">管理员<%=n.getName()%></span>！
		</p>
	</div>

	<div class="management-options">
		<div class="content">
			<div class="content1">
				<p>活动上新</p>
			</div>
			<div class="content2"
				onclick="document.location='ManagementOfMenu.jsp';">
				<p>管理菜单</p>
			</div>

			<div class="content3"
				onclick="document.location='ManagementOfUser.jsp';">
				<p>管理用户</p>
			</div>
			<div class="content4">
				<p>操作记录</p>
			</div>
		</div>
		<br /> <br /> <br />
	</div>

	<div id="personalInfo">
		<div class="personalInfo">
			<br /> <br /> <br />
			<p>个人信息</p>
			<hr />

			<div>
				<br />
				<div class="content"
					style="margin-left: 300px; color: white; font-size: 25px;">
					<table class="info-table" id="info-table">
						<tr>
							<td>姓名：</td>
							<td><%=n.getName()%></td>
						</tr>
						<tr>
							<td>手机：</td>
							<td><%=n.getTele()%></td>
						</tr>
						<tr>
							<td>邮箱：</td>
							<td><%=n.getMail()%></td>
						</tr>
					</table>
					<form class="personal-info-form" id="edit-info-form" method="POST"
						action="Manage_users_jsp/Check_ModifyInfo.jsp"
						onSubmit="return confirmInfo(this);" style="">
						<table class="edit-info-table" id="edit-info-table"
							style="display: none;">
							<tr>
								<td>姓名：</td>
								<td><input type="text" id="name_temp" name="name"
									value=<%=n.getName()%>
									style="width: 300px; height: 28px; font-size: 20px;" /></td>
							</tr>
							<tr>
								<td>手机：</td>
								<td><input type="text" id="phoneNum_temp" name="phoneNum"
									value=<%=n.getTele()%>
									style="width: 300px; height: 28px; font-size: 20px;" /></td>
							</tr>
							<tr>
								<td>邮箱：</td>
								<td><input type="text" id="eMail_temp" name="eMail"
									value=<%=n.getMail()%>
									style="width: 300px; height: 28px; font-size: 20px;" /></td>
							</tr>
						</table>
						<div class="buttons" align="right" style="margin-right: 100px;">
							<button id="modifyInfoBtn" class="btn" type="button"
								onclick="showEditInfoTabel()">修改信息</button>
							<button id="modifyPwdBtn" class="btn" type="button"
								onclick="showEditPwdTabel()">更换密码</button>
							<input id="confirmInfoBtn" class="btn" type="submit" value="确认修改"
								style="display: none;" />
							<button id="cancelModifyInfoBtn" class="btn" type="button"
								onclick="cancelModifying()" style="display: none;">取消修改</button>
						</div>
					</form>
					<form class="account-pwd-form" id="edit-pwd-form" method="POST"
						action="Manage_users_jsp/Check_ModifyPwd.jsp"
						onSubmit="return confirmPwd(this);" style="display: none;">
						<table class="edit-pwd-table" id="edit-pwd-table" style="">
							<tr>
								<td>原密码：</td>
								<td><input type="password" id="oldPwd" name="oldPwd"
									style="width: 300px; height: 28px; font-size: 20px;" /></td>
							</tr>
							<tr>
								<td>新密码：</td>
								<td><input type="password" id="newPwd1" name="newPwd1"
									style="width: 300px; height: 28px; font-size: 20px;" /></td>
							</tr>
							<tr>
								<td>确认新密码：</td>
								<td><input type="password" id="newPwd2" name="newPwd2"
									style="width: 300px; height: 28px; font-size: 20px;" /></td>
							</tr>
						</table>
						<div class="buttons" align="right" style="margin-right: 100px;">
							<input id="confirmPwdBtn" class="btn" type="submit" value="确认"
								style="display: none;" />
							<button id="cancelModifyPwdBtn" class="btn" type="button"
								onclick="cancelModifying()" style="display: none;">取消</button>
						</div>
					</form>
				</div>
			</div>
		</div>
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


