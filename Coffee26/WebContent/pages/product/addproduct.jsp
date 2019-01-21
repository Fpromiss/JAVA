<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.sql.*,java.io.*,javax.swing.*,Action.*,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	
	<title>杨超越的咖啡厅</title>
	
	<!-- meta -->
	<meta charset="UTF-8">
	
	<!-- css -->
	<link rel="stylesheet" href="../CSS/GeneralStyle.css">
	<link rel="stylesheet" href="../CSS/SignUpAndLogIn.css">
	
	<!-- js -->
	<script>
	function isValid(form) {
		if (form.pname.value == "") {
			alert("请输入产品名！");
			return false;
		} else if (form.pstock.value == "") {
			alert("请设置库存！");
			return false;
		} else if (form.price.value == "") {
			alert("请设置价格！");
			return false;
		}else if (form.ptype.value =="") {
			alert("请设置类型！");
			return false;
		}
		else if (form.fileName.value =="") {
			alert("请选择图片！");
			return false;
		}
		
		else {
			return false;
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
				<h1><a href="../Home.jsp">YCYCafe</a></h1>
			</div>
			<div class="options">
				<ul>
					<li><a href="../Home.jsp" class="active">首页</a></li>
					<%
					if (n.getId().equals("U")) {
					%>
					<li><a href="../Menu.jsp">菜单</a></li>
					<%
					}else{
						%>
						<li><a href="../ManagementOfMenu.jsp">菜单</a></li>	
						<% 
					}
					%>
					<%
						if (!n.is_Have()) {
					%>
						<li id="log-in"><a href="../LogIn.jsp">登录</a></li>
						<li id="sign-up"><a href="../SignUp.jsp">注册</a></li>
					<%
						} else {
							if (n.getId().equals("U")) {
					%>
						<li id="personal-center" ><a href="../PersonalCenterOfUser.jsp">个人中心</a></li>
					<%
							} else {
					%>
						<li id="personal-center" ><a href="../PersonalCenterOfAdmin.jsp">个人中心</a></li>
					<%
							}
					%>
						<li id="log-out" ><a onclick="logOut()" href="../LogOut.jsp">退出登录</a></li>
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
				<br/><br/><br/>
			</div>
			<div class="info">
				<h1 style="color: #300505;">ADD PRODUCT</h1>
				<h2>添加商品</h2>
			</div>
		</div>
	</header>
	
	<!--  -->
	<div class="input-info">
		<div class="display">
			<div>
				<div>
					<img src="../images/logo.png" alt="YCYCafe_Logo" width="450" height="450" style="margin-top: 0px"/>
				</div>
			</div>
			<div>
				<div class="sign-up-form">
				<h2>增加餐品</h2>
					 <form name="form-add" method="post" action="addInfo.jsp"
					       onSubmit="return isValidAdd(this);">
						<br/>产品名称: <br/><input type="text" name="pname" size="40">
						<br/>产品类型: <br/><input type="text" name="ptype" size="40">
						<br/>产品库存: <br/><input type="text" name="pstock" size="40">
						<br/>产品价格: <br/><input type="text" name="pprice" size="40">
						<br/>产品图片: <br/><input type="file" name="fileName" size="40">
						<br/><br/><input type="submit" class="btn" value="提交"/><br/><br/>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>


