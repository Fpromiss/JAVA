<%@ page language="java" import="java.sql.*,Action.*"
	contentType="text/html;charset=utf-8"%>

<!--                 删除菜单                                    -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>删除产品信息</title>

</head>

<body>

	<%
	//设置编码方式
		request.setCharacterEncoding("utf-8");
	//获取角标名
		String i=request.getParameter("i");
		int j=Integer.parseInt(i);
		Product p=new Product();
		//删除产品
		p.deleteProduct(j);
	%>

	<script type="text/javascript" language="javascript">
	    alert("删除成功！");
		window.document.location.href = "../ManagementOfMenu.jsp";
	</script>
     
</body>

</html>
