<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="UTF-8"
	import="java.sql.*,java.io.*,javax.swing.*,Action.*,java.util.ArrayList"%>

<!DOCTYPE HTML>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>杨超越的咖啡厅</title>
<link rel="stylesheet" type="text/css" href="CSS/GeneralStyle.css" />
<link rel="stylesheet" type="text/css" href="CSS/Menu.css" />
<script>
	function isValidAdd(form) {
		if (form.pname.value == "") {
			alert("产品名称不能为空!");
			return false;
		}
		if (form.ptype.value == "") {
			alert("产品类型不能为空!");
			return false;
		}
		if (form.pstock.value == "") {
			alert("产品库存不能为空!");
			return false;
		}
		if (form.pprice.value == "") {
			alert("产品单价不能为空!");
			return false;
		}
		return true;
	}
</script>
<script>
	function isValidFind(form) {
		if (form.pname.value == "") {
			alert("产品名称不能为空!");
			return false;
		}
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
					<li><a href="Menu.jsp" class="active">菜单</a></li>
					<%
						} else {
					%>
					<li><a href="ManagementOfMenu.jsp" class="active">菜单</a></li>
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

	<header class="header">
		<div class="display" align="center">
			<div>
				<br />
				<br />
				<br />
			</div>
			<div class="info" style="text-align: center;">
				<br />
				<br />
				<h1 style="color: #300505; font-size: 90px">MENU</h1>
				<h2 style="font-size: 30px;">独特品味，超越把握</h2>
				<br />
			</div>
		</div>
	</header>



	<%
		Administrator admin = new Administrator();
		ArrayList<Product> array = new ArrayList<Product>();
		Product temp = new Product();
		array.add(temp);
		array = admin.SelectAllProducts();
	%>
	<div class="content">
		<div>
			<div class="menu" align="center">
				<div style="display: flex; justify-content: space-around;">
					<div class="search-form-div" align="center"
						style="color: white; font-size: 18px;">
						<form method="post" action="product/findProduct.jsp"
							onSubmit="return isValidFind(this);">
							<table>
								<tr>
									<td>请输入名称查找：</td>
									<td><input type="text" name="pname"></td>
									<td><input type="submit" value="go"></td>
								</tr>
							</table>
						</form>
					</div>
					<div class="search-form-div" align="center"
						style="color: white; font-size: 18px;">
						<form method="post" action="product/findProductWithType.jsp"
							onSubmit="return isValidFind(this);">
							<table>
								<tr>
									<td>请输入类型查找：</td>
									<td><input type="text" name="ptype"></td>
									<td><input type="submit" value="go"></td>
								</tr>
							</table>
						</form>
					</div>
					<div>
						<button id="shoppingCart" class="btn" type="button"
							onclick="document.location='product/addproduct.jsp';">增加商品</button>
					</div>
				</div>
				<div class="menu-content" style="width: 80%;">
					<%
						int i = 0;
						int j = 0;
						String path_name = "";
						for (i = 0; i < array.size(); i++) {
					%>
					<div class="menu-content-item"
						style="float: left; border: 1px solid #ccc; margin: 5px; width: 200px;">
						<%
							path_name = (String) (array.get(i).get_Route());
						%>
						<img src=<%=path_name%> width="200" height="100" />
						<div>
							<p><%=array.get(i).get_Name()%>
								&emsp;
								<%=array.get(i).get_Type()%></p>
							<p>
								库存：<%=array.get(i).get_Stock()%></p>
							<p>
								价格：<%=array.get(i).get_Price()%></p>
							<p>
								销量：<%=array.get(i).get_Count()%></p>
							<form method="post" action="product/changeInfo.jsp">
								<input type="hidden" name="i" size="20" value=<%=i%> /> <input
									type="submit" value="修改"></input>
							</form>
							<form method="post" action="product/deleteInfo.jsp">
								<input type="hidden" name="i" size="20" value=<%=i%> /> <input
									type="submit" value="删除"></input>
							</form>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>

</body>
</html>