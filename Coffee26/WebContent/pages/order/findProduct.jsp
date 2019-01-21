<%@ page language="java" import="java.sql.*,Action.*"
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

<body style="background:url(../images/backgroundPic1.jpg);background-repeat:repeat;background-size:cover;">

<!-- Navigation Bar: Home | Menu | Log in | Sign in | My center | Exit... -->
	<!-- Public Bar -->
	<%
		Now n = new Now();
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
					<li><a href="../Menu.jsp">菜单</a></li>
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
	
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<div style="text-align:center;">
<div style="width:25%;float:left"></div>

<div style="width:50%;float:left;background-color:rgba(255,255,255,0.5);">
   <%
        //设置编码方式
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("pname");//获取产品名
		System.out.println(name);
        Administrator admin=new Administrator();
        Product p = new Product();
        p=admin.SelectProduct_Name(name);//获取产品
        //如果满足条件 说明产品存在 则输出产品信息
        if(p.get_Name()!=""&&p.get_Name()!=null){
        	 %>

	<table style="text-align:left;margin:auto;color:black;font-size:27px;width:400px">
	 <caption style="text-align:left;font-size:31px;">查询到的餐品信息：</caption>
	  <tr>
	   <td>
	   <img src=<%="../"+p.get_Route() %> width="200" height="100"/>
	   </td>
	   </tr>
	   <tr>
	   <td>品名：<span><%=p.get_Name()%></span></td>
	   </tr>
	    <tr>
	   <td>类型：<span><%=p.get_Type()%></span></td>
	   </tr>
	   <tr>
	   <td>库存：<span><%=p.get_Stock()%></span></td>
	   </tr>
	   <tr>
	   <td>单价：<span><%=p.get_Price()%></span></td>
	   </tr>
	  
	
	</table>
	
    <script type="text/javascript" language="javascript">
		alert("查找成功!");
	</script> 	
  
	<%
        }
        else{//如果不满足条件 说明查找失败！
       
	%> 
	 <script type="text/javascript" language="javascript">
		alert("查找失败!");
		window.document.location.href = "../Menu.jsp";
	</script>  
	<%
        }
	%>
	</div>
	</div>
</body>

</html>
