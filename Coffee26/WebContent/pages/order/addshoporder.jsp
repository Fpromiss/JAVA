<%@ page language="java" import="java.sql.*,Action.*,java.util.ArrayList"
	contentType="text/html;charset=utf-8"%>

<!--                 管理购物车中菜品数量                             -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>管理购物车中菜品数量</title>

</head>

<body>

	<%
	  //编码方式
		request.setCharacterEncoding("utf-8");
	    //获取添加下标
    	String i=request.getParameter("i");
	    int j=Integer.parseInt(i);
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
	   //管理购物车中菜品数量
	   String sql1="select * from addorder where ouser="+"'"+nuser+"'";
	   System.out.println(sql1);
	   rs =stmt.executeQuery(sql1);
	   System.out.println(j);
	   for(int k=0;k<=j;k++){
		   rs.next();
	   }
	   String name=rs.getString(2);//获取名称
	   String num=rs.getString(5);//获取数量
	   int number=Integer.parseInt(num);//转换类型
	   number=number+1;//数量+1
	   //System.out.println(number);
	   //获取库存量
	    String sql2="select pstock from products where pname="+"'"+name+"'";
		   System.out.println(sql2);
		   Statement stmt1=conn.createStatement();
		   ResultSet rs1 =stmt1.executeQuery(sql2);
		   int num2=0;
		   if(rs1.next()){
			   num2=rs1.getInt(1);
		   }
		   //如果当前加完后数量小于等于库存量 进行更新操作
	   if(number<=num2){
		   String sql3="update addorder set oamount="+"'"+number+"'"+" where oname="+"'"+name+"'";
		   System.out.println(sql3);
		   stmt.executeQuery(sql3);  
		   conn.close();//关闭连接
	%>

	<script type="text/javascript" language="javascript">
		alert("修改数量成功!");
		window.document.location.href = "../shop.jsp";
	</script>
  <%
	   }
	   else{
  %>
  <script type="text/javascript" language="javascript">
		alert("修改数量失败 选中数量超出库存!");
		window.document.location.href = "../shop.jsp";
	</script>
  <%
	   }
  %>
</body>

</html>
