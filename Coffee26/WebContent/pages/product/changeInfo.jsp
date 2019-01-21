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
<link rel="stylesheet" href="../CSS/GeneralStyle.css">
<link rel="stylesheet" href="../CSS/Management.css">

<!-- JS -->
<script>
	function confirmModify(form) {
		var isConfirmed = confirm("注意：确定要修改吗？");
		if (isConfirmed == true) {
			return true;
		} else {
			return false;
		}
	}
</script>

</head>
<body>

	<!-- Public Navigation Bar -->
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
				<br />
				<br />
				<br />
				<br />
			</div>
			<div class="info">
				<h1 style="color: #300505;">MANAGEMENT OF MENU</h1>
				<h2>你好，管理员！</h2>
			</div>
		</div>
	</header>

	<%
	//设置编码方式
		request.setCharacterEncoding("utf-8");
	//获取角标
		String i=request.getParameter("i");
		int j=Integer.parseInt(i);//类型转换
		Administrator admin =new Administrator();
		ArrayList<Product> array = new ArrayList<Product>();
		array=admin.SelectAllProducts();
		Product p = new Product();
		p=array.get(j);//获取当前产品
		//链接数据库
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		//从当前表删除
		String sql0="delete from nproduct";
		ResultSet rs = stmt.executeQuery(sql0);
		//插入修改信息
		String sql = "insert into nproduct values('" + p.get_Name() + "','" + p.get_Type()
				+ "'," + p.get_Stock() + "," + p.get_Price() + ",'"+ p.get_Route() +"',"+p.get_Count()+")";
		stmt.executeQuery(sql);
		conn.close();
		
	%>
	<div class="anUser" align="center">
		<br />
		<h1 style="color: white">用户信息</h1>
		<div class="content" align="center"
			style="color: white; font-size: 25px;">
			<form class="user-info-form" id="user-info-form" method="POST"
				action="addChangeProduct.jsp" onSubmit="return confirmModify(this);">
				<table class="user-info-table" id="user-info-table">
				
							<tr>
						<td>产品名：</td>
						<td><input type="text" id="name_temp" name="newname" value=<%=p.get_Name()%>
							style="width: 300px; height: 28px; font-size: 20px;" /></td>
					</tr>
					<tr>
						<td>产品类型：</td>
						<td><input type="text" id="name_temp" name="newtype" value=<%=p.get_Type()%>
							style="width: 300px; height: 28px; font-size: 20px;" /></td>
					</tr>
					<tr>
						<td>产品库存：</td>
						<td><input type="text" id="phoneNum_temp" name="newstock"
							value=<%=p.get_Stock()%> style="width: 300px; height: 28px; font-size: 20px;" />
						</td>
					</tr>
					<tr>
						<td>产品价格：</td>
						<td><input type="text" id="eMail_temp" name="newprice"
							value=<%=p.get_Price()%> style="width: 300px; height: 28px; font-size: 20px;" />
						</td>
					</tr>
				</table>
				<input type="hidden" name="i" size="20" value=<%= i %> />
				<div class="buttons">
					<input id="confirmBtn" class="btn" type="submit" value="修改" />
					<button id="cancelBtn" class="btn" type="button" onclick="document.location='../ManagementOfMenu.jsp';">取消</button>
				</div>
			</form>
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


