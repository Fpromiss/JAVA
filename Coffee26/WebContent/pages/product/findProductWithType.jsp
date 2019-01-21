<%@ page language="java" import="java.sql.*,Action.*,java.util.*"
	contentType="text/html;charset=utf-8"%>

<!--                 查找菜单                                    -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>查找菜单</title>

<!-- css -->
<link rel="stylesheet" href="../CSS/style1.css">

<script>
	
</script>

</head>

<body
	style="background: url(../images/backgroundPic1.jpg); background-repeat: repeat; background-size: cover;">

	<!-- Navigation Bar: Home | Menu | Log in | Sign in | My center | Exit... -->
	<!-- Public Bar -->
	<%
		Now n = new Now();
		n.is_Have();
	%>

	<!-- Public Navigation Bar -->
	<nav>
	<div class="bar">
		<div class="logo">
			<h1>
				<a href="../Home.jsp">YCYCafe</a>
			</h1>
		</div>
		<div class="options">
			<ul>
				<li><a href="../Home.jsp">首页</a></li>
				<%
					if (n.getId().equals("U")) {
				%>
				<li><a href="../Menu.jsp" class="active">菜单</a></li>
				<%
					} else {
				%>
				<li><a href="../ManagementOfMenu.jsp" class="active">菜单</a></li>
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
				<li id="personal-center"><a href="../PersonalCenterOfUser.jsp">个人中心</a></li>
				<%
					} else {
				%>
				<li id="personal-center"><a href="../PersonalCenterOfAdmin.jsp">个人中心</a></li>
				<%
					}
				%>
				<li id="log-out"><a onclick="logOut()" href="../LogOut.jsp">退出登录</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
	</nav>

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div style="text-align: center;">
		<div style="width: 25%; float: left"></div>

		<div
			style="width: 50%; float: left; background-color: rgba(255, 255, 255, 0.5);">
			<%
				//设置编码方式
				request.setCharacterEncoding("utf-8");
				//获取名称
				String type = request.getParameter("ptype");
				Administrator admin = new Administrator();
				ArrayList<Product> p = new ArrayList<Product>();
				p = admin.SelectProduct_Type(type);//获取产品
				if (p.size() > 0) {
			%>

			<table
				style="text-align: left; margin: auto; color: black; font-size: 27px; width: 400px">
				<caption style="text-align: left; font-size: 31px;">查询到的餐品信息：</caption>
				<%
					for (int i = 0; i < p.size(); i++) {
				%>
				<tr>
					<td><img src=<%="../" + p.get(i).get_Route()%> width="200"
						height="100" /></td>
				</tr>
				<tr>
					<td>品名：<span><%=p.get(i).get_Name()%></span></td>
				</tr>
				<tr>
					<td>类型：<span><%=p.get(i).get_Type()%></span></td>
				</tr>
				<tr>
					<td>库存：<span><%=p.get(i).get_Stock()%></span></td>
				</tr>
				<tr>
					<td>单价：<span><%=p.get(i).get_Price()%></span></td>
				</tr>
				<%
					}
				%>
				<tr>
					<%
						if (n.getId().equals("A")) {
					%>
					<td>
						<form name="return" method="post" action="../ManagementOfMenu.jsp">
							<input type="submit" value="返回"
								style="margin: 0 0 0 5px; border-style: 1px; width: 55px; height: 36px; background-repeat: no-repeat; font-family: 'FZQingKeBenYueSongS-R-GB'; font-size: 25px; color: black;" />
						</form>

					</td>
					<%
						} else {
					%>
					<td>
						<form name="return" method="post" action="../Menu.jsp">
							<input type="submit" value="返回"
								style="margin: 0 0 0 5px; border-style: 1px; width: 55px; height: 36px; background-repeat: no-repeat; font-family: 'FZQingKeBenYueSongS-R-GB'; font-size: 25px; color: black;" />
						</form> <%
						}
						%>
					</td>
				</tr>


			</table>

			<script type="text/javascript" language="javascript">
				alert("查找成功!");
			</script>


			<%
				} else {
			%>
			<%
						if (n.getId().equals("A")) {
					%>
			<script type="text/javascript" language="javascript">
				alert("查找失败!");
				window.document.location.href = "../ManagementOfMenu.jsp";
			</script>
			<%
						} else {
					%>
			<script type="text/javascript" language="javascript">
				alert("查找失败!");
				window.document.location.href = "../Menu.jsp";
			</script>
			<%
						}
				}
			%>
		</div>
	</div>
</body>

</html>
