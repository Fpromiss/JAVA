<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"
	import="java.sql.*,java.io.*,javax.swing.*,Action.*,java.util.ArrayList"%>
<!DOCTYPE HTML>
<html>
<head>

<title>Cafe_test</title>

<!-- css -->
<link rel="stylesheet" href="CSS/style1.css">

<script>
	
</script>

</head>

<body
	style="background-image: url(images/backgroundPic1.jpg); background-repeat: repeat; background-size: cover;">

	<!-- Navigation Bar: Home | Menu | Log in | Sign in | My center | Exit... -->
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
					<li><a href="Menu.jsp" class="active">菜单</a></li>
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


	<!-- Header: Logo | Info -->
	<!-- Decorative and Public Header -->
	<header class="header">
		<div class="display" align="center">
			<div>
				<br />
				<br />
				<br />
				<br />
				<br />
			</div>
			<div class="display-info">
				<h1 style="color: #300505;">我的购物车</h1>
				<h2>my cart</h2>
			</div>
		</div>
	</header>

	<div style="float: left;">
		<div style="margin: -60px 0 0 140px; float: left;">
			<img src="images/logo.png" width="450px" height="450px" alt="" />
		</div>
		<div class="keybody" style="margin: 20px 0 0 210px; float: left;">
			<table width="700px"
				style="float: left; text-align: center; color: black; background-color: rgba(255, 255, 255, 0.6);"
				border="1" border-color="white" bgcolor="white" cellspacing="0"
				cellpadding="3">
				<caption
					style="color: black; font-family: FZQingKeBenYueSongS-R-GB; font-size: 35px;">购物车列表</caption>
				<thead>
					<tr>
						<th align="center">品名</th>
						<th align="center">数量</th>
						<th align="center">单价</th>
						<th align="center">加减按钮</th>
						<th align="center">小计</th>
					</tr>
				</thead>

				<%
					//连接数据库
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie",
							"947312014");
					Statement stmt = conn.createStatement();
					String sql = "select *from addorder";
					System.out.println(sql);
					ResultSet rs = stmt.executeQuery(sql);
					String user = "";
					int i = 0;
				%>
				<tbody>
					<%
						int smallaccount = 0;
						int totalPrice = 0;
						while (rs.next()) {
							user = rs.getString(1);
							String name = rs.getString(2);
							String price = rs.getString(4);
							String num = rs.getString(5);
							smallaccount = Integer.valueOf(rs.getString(4)) * Integer.valueOf(rs.getString(5));
							totalPrice += smallaccount;
					%>

					<tr>
						<th><%=name%></th>
						<td><%=num%></td>
						<td><%=price%></td>
						<td>
							<div style="display: inline-block;">
								<div style="float: left;">
									<form method="post" action="order/deleteshoporder.jsp">
										<input type="hidden" name="i" size="20" value=<%=i%> /> <input
											type="submit" value="-"
											style="width: 40px; height: 30px; font-family: 'FZQingKeBenYueSongS-R-GB'; font-size: 25px; color: black;"></input>
									</form>
								</div>
								<div style="float: left;">
									<form method="post" action="order/addshoporder.jsp">
										<input type="hidden" name="i" size="20" value=<%=i%> /> <input
											type="submit" value="+"
											style="margin: 0 0 0 5px; width: 40px; height: 33px; font-family: 'FZQingKeBenYueSongS-R-GB'; font-size: 25px; color: black;"></input>
									</form>
								</div>
							</div>
						</td>
						<td><%=smallaccount%></td>
						<%
							++i;
							}
						%>
					</tr>
				</tbody>
			</table>
			<div style="clear: both; height: 0; overflow: hidden;"></div>
			<div
				style="margin: 30px 0 0 150px; float: left; background-color: rgba(255, 255, 255, 0.6);">
				<form method="post" action="order/submitorder.jsp">
					<input type="submit" value="提交订单"
						style="background-color: white; border-style: 1px; width: 110px; height: 40px; background-repeat: no-repeat; font-family: 'FZQingKeBenYueSongS-R-GB'; font-size: 18px; color: black;" />
				</form>
			</div>
			<div
				style="margin: 30px 0 0 150px; float: left; background-color: rgba(255, 255, 255, 0.6);">
				<form method="post" action="order/history.jsp">
					<input type="submit" value="历史订单"
						style="background-color: white; border-style: 1px; width: 110px; height: 40px; background-repeat: no-repeat; font-family: 'FZQingKeBenYueSongS-R-GB'; font-size: 18px; color: black;" />
				</form>
			</div>
		</div>
	</div>

</body>
</html>