<%@ page language="java" contentType="text/html;charset=utf-8"
	import="java.sql.*,Action.*"%>
<!DOCTYPE html>
<html>
<head>

<title>杨超越的咖啡厅</title>

<!-- meta -->
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="CSS/GeneralStyle.css">
<link rel="stylesheet" href="CSS/Home.css">

<!-- js -->
<script>
	function logOut() {
		var isConfirmed = confirm("确定退出？");
		if (isConfirmed == true) {
			return true;
		} else {
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
				<h1>
					<a href="Home.jsp">YCYCafe</a>
				</h1>
			</div>
			<div class="options">
				<ul>
					<li><a href="Home.jsp" class="active">首页</a></li>
					<%
						if (n.getId().equals("U")) {
							System.out.println(123456);
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
				<img src="images/logo.png" alt="YCYCafe_Logo" width="400"
					height="400" style="margin-top: 140px" />
			</div>
			<div class="info">
				<h1>超越咖啡</h1>
				<h2>每一滴都是承诺</h2>
			</div>
		</div>
	</header>

	<!-- Selected Introductions -->
	<div class="selected">
		<br />
		<br />
		<br />
		<br />
		<br />
		<div class="item">
			<div class="show">
				<img src="images/homeSelected1.PNG" alt="selected_1" width="800"
					height="450" />
			</div>
			<div>
				<h3 style="margin-top: 0px;">用心调制每一种口味</h3>
				<p style="font-size: 15px;">
					来自高原的新鲜咖啡豆， <br />传统烘焙、特别提纯、独特配比， <br />与健康的咖啡伴侣完美融合， <br />彰显极致工艺。
					<br />超越咖啡， <br />醇和独特的香气， <br />与意式咖啡的浓苦， <br />蓝山咖啡的酸涩完全不同， <br />气味香浓，醇厚优雅，
					<br />入口极为滑顺， <br />舒活畅快感瞬间溢满口腔， <br />若即若离的烟熏感悠长、持久， <br />令人回味。 <br />原色原香，多重口感，
					<br />完美诠释了金牌超越咖啡的古老神秘与独树一帜。
				</p>
			</div>
		</div>
		<div class="item" align="center">
			<div class="info" align="center">
				<h2>
					超越<span style="color: red;">精选</span>
				</h2>
				<p style="color: white; font-size: 25px; margin-top: 0px;">
					只为更好的<span style="color: red;">品质</span>
				</p>
			</div>
		</div>
		<div class="item">
			<div>
				<h3 style="margin-top: 0px;">精心挑选每一粒咖啡豆</h3>
				<p style="font-size: 15px;">
					年轮记载着一棵树木的雨雪沧桑， <br />皱纹铭刻着一个人走过的路遇过的人， <br />解放着一切心灵与时间的藩篱。 <br />红腹绿背的极乐鸟在海平线上高歌，
					<br />浓郁醇厚的咖啡香伴着落日渐渐散开， <br />超越咖啡， <br />源自危地马拉Isabel庄园种植的咖啡豆， <br />裹挟着清纯优雅的自然气息而来。
					<br />自由鸟的图腾是时间的标本， <br />轻轻搅动杯中的咖啡， <br />像撬动地球的支点， <br />忙碌的人生，束缚的灵魂，你是自己的主人，
					<br />超越咖啡， <br />咖啡中永恒的贵族。
				</p>
			</div>
			<div class="show">
				<img src="images/homeSelected2.PNG" alt="selected_2" width="800"
					height="450" />
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
	</div>
	<hr />

	<!-- Preview: Introductions -->
	<div class="preview">
		<br />
		<br />
		<br />
		<div class="content">
			<div class="content1">
				<p>新品上市</p>
			</div>
			<div class="content2">
				<p>网红热款</p>
			</div>

			<div class="content3">
				<p>优惠活动</p>
			</div>
			<div class="content4">
				<p>加入我们</p>
			</div>
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


