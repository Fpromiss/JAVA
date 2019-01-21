<%@ page language="java" import="java.sql.*,Action.*"
	contentType="text/html;charset=utf-8"%>

<!--                 添加菜单                                    -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>添加菜单 </title>

</head>

<body>

	<%
	//设置编码方式
		request.setCharacterEncoding("utf-8");
	//获取产品提交信息
		String name = request.getParameter("pname");
		String type = request.getParameter("ptype");
		String stock = request.getParameter("pstock");
		String price= request.getParameter("pprice");
		String fileName=request.getParameter("fileName");
		String route="images/"+fileName;
		System.out.println(route);
		//创建一个产品对象
		Product p=new Product(name,type,Integer.parseInt(stock),Integer.parseInt(price),route);
        //插入一个产品
		int r=p.Insert2Database();
		if(r>0){ //如果成功
	%>

	<script type="text/javascript" language="javascript">
		alert("添加信息成功!");
		window.document.location.href = "../ManagementOfMenu.jsp";
	</script>
     <%
		}
		else{//如果失败
     %>
     <script type="text/javascript" language="javascript">
		alert("添加失败!");
		window.document.location.href = "../ManagementOfMenu.jsp";
	</script>
	<%
		}
	%>
     
</body>

</html>
