<%@ page language="java" import="java.sql.*,Action.*,java.util.ArrayList,java.util.Date,java.text.SimpleDateFormat"
	contentType="text/html;charset=utf-8"%>

<!--                 历史订单                                   -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>历史订单</title>
<link rel="stylesheet" type="text/css" href="../CSS/history.css" />
<script type="text/javascript" src="js/test.js"></script>
</head>

<body  style="background-image:url(../images/backgroundPic1.jpg);background-repeat:repeat-y;background-size:cover;" >
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
	
<div class="keTitle" style="text-align:center;font-family:FZQingKeBenYueSongS-R-GB;">
<br/><br/>
    <h1  style="color: #300505;font-size:70px">历史订单</h1>
   <h2 style="margin:-40px 0 0 0;color:white">history order</h2>
</div>
<br />
<div style="width:100%;background-color:rgba(0,0,0,0.2);">
<br /><br /><br /><br /><br /><br />
<div style="margin:-70PX 0 0 30px;float:left;"><img src="../images/logo.png" width="400px" height="400px" style="margin:0 0 0 100px" alt=""/></div>
<table style="
	text-align:center;
	color:black;
	font-size:20px;
	font-family:FZQingKeBenYueSongS-R-GB;
	border:0px solid #666666;
	border-top-width:2px;
	border-bottom-width:3px;
	background-color:rgba(255,255,255,0.5);" align="center" border="1" cellspacing="0" cellpadding="3" width="500px">
	      <caption style="color:white;font-family:FZQingKeBenYueSongS-R-GB;font-size:30px;border-bottom:1px;">历史购物清单</caption>
	      <thead>
                    <tr>
                        <th align="center" style="border-left:0px;border-right:0px">
                            个人账号
                        </th>
                        <th align="center" style="border-left:0px;border-right:0px">
                            品名
                        </th>
                        <th align="center" style="border-left:0px;border-right:0px">
                           类型
                        </th>
                        <th align="center" style="border-left:0px;border-right:0px">
                            单价
                        </th>
                         <th align="center" style="border-left:0px;border-right:0px">
                           数量
                        </th>
                    </tr>
                </thead>
                
                 <%
       //连接数据库
      Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
     //获取当前用户名
	    String sql="select nnumber from nowuser";
	    ResultSet rs =stmt.executeQuery(sql);
	    String nuser="";
	    if(rs.next()){
	    	nuser=rs.getString(1);
	    }    
	    //根据当前用户名从历史订单表中获取数据
	   String sql1="select * from historyorder where huser="+"'"+nuser+"'"+"order by id";
	   System.out.println(sql1);
	   rs =stmt.executeQuery(sql1);
	   %>
                <tbody>
                
                <%
                int flag=1;
                //按照表单输出数据
                while(rs.next()){
          	      String id=rs.getString(1);   
          	      if(id==""){
          	         flag=0;
          	         break;
          	      }
          	      String name=rs.getString(3);
          	      String type=rs.getString(4);
          	      String price=rs.getString(5);
          	      String amount=rs.getString(6);
                %>
                <tr>
                	<th width="100px" style="border-left:0px;border-right:0px"><%=id%></th>
                	<td width="100px" style="border-left:0px;border-right:0px"><%=name %></td>
                	<td width="100px" style="border-left:0px;border-right:0px"><%=type %></td>
                	<td width="100px" style="border-left:0px;border-right:0px"><%=price %></td>
                	<td width="100px" style="border-left:0px;border-right:0px"><%=amount %></td>
                	</tr>
                	<%
                }
                
                conn.close();
                //如果flag=0 说明历史订单为空 
                if(flag==0){
                	%>
     <script type="text/javascript" language="javascript">
		alert("购物车为空!");
		window.document.location.href = "../shop.jsp";
	</script>
	<%
	  }
     %>
                </tbody>
  </table>

</div>
</body>

</html>