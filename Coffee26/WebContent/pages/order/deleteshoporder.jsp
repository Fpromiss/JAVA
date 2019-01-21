<%@ page language="java" import="java.sql.*,Action.*,java.util.ArrayList"
	contentType="text/html;charset=utf-8"%>

<!--                 删除购物车中菜品数量                                   -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title> 删除购物车中菜品数量</title>

</head>

<body>

	<%
	//设置编码方式
		request.setCharacterEncoding("utf-8");
	 //获取添加下标
	String i=request.getParameter("i");
    int j=Integer.parseInt(i);
   
    //连接数据库
    Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
  //获取当前用户名
    String sql0="select nnumber from nowuser";
    ResultSet rs =stmt.executeQuery(sql0);
    String nuser="";
    if(rs.next()){
    	nuser=rs.getString(1);
    }    
    // 删除购物车中菜品数量           
	   String sql1="select * from addorder where ouser="+"'"+nuser+"'";
	   System.out.println(sql1);
	   rs =stmt.executeQuery(sql1);
	   System.out.println(j);
	   for(int k=0;k<=j;k++){
		   rs.next();
	   }
	   String name=rs.getString(2);//获取名称
	   String num=rs.getString(5);//获取数量
	   int number=Integer.parseInt(num);//转化类型
	   number=number-1;//数量-1
	   System.out.println(number);
	   if(number>0){//如果-1后数量>0 说明可以进行更新操作
		   String sql2="update addorder set oamount="+"'"+number+"'"+" where oname="+"'"+name+"'";
		   System.out.println(sql2);
		   stmt.executeQuery(sql2);
	   }
	   else{//如果-1后数量>0 说明直接删除该产品从addorder表
		  String sql3="delete from addorder where oname="+"'"+name+"'";
		  System.out.println(sql3);
		  stmt.executeQuery(sql3);
	   }
	   conn.close();//关闭连接
	%>

	<script type="text/javascript" language="javascript">
		alert("成功从购物车中删除!");
		window.document.location.href = "../shop.jsp";
	</script>
    
     
</body>

</html>
