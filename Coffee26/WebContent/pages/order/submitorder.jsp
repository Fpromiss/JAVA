<%@ page language="java" import="java.sql.*,Action.*,java.util.ArrayList,java.util.Date,java.text.SimpleDateFormat"
	contentType="text/html;charset=utf-8"%>

<!--                 提交订单                                   -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>提交订单</title>

</head>

<body>
    <%
       //连接数据库
      Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		//时间
       Date now = new Date(); 
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
	   String otime = dateFormat.format( now ); //获取时间
	   System.out.println(otime); 
	   String sql="select *from addorder";
	   System.out.println(sql);
	   ResultSet rs =stmt.executeQuery(sql);
	   /*
	   提交订单：
	   1.产品表更新库存；
	   2.把addorder中数据加入history表 
	   3.把addorder中数据删除；
	   */   
	   while(rs.next()){
		   String user=rs.getString(1);//获取用户名
		   String name=rs.getString(2);//获取产品名
		   String type=rs.getString(3);//获取类型
		   String price=rs.getString(4);//获取价格
		   String num=rs.getString(5);//获取数量
		   int num1= Integer.parseInt(num);//转化类型
		   //获取库存
		   String sql1="select pstock from products where pname="+"'"+name+"'";
		   System.out.println(sql1);
		   Statement stmt1=conn.createStatement();
		   ResultSet rs1 =stmt1.executeQuery(sql1);
		   int num2=0;
		   if(rs1.next()){
			   num2=rs1.getInt(1);
		   }
		   num2=num2-num1;//num2 是当前库存 这里不需要判断因为加入购物车时候就判断过了
		   //更新库存
		   String sql2="update products set pstock="+"'"+String.valueOf(num2)+"'"+" where pname="+"'"+name+"'";
		   System.out.println(sql2);
		   Statement stmt2=conn.createStatement();
		   stmt2.executeUpdate(sql2);
		   
		  //获取历史购买量
		   sql2="select pcount from products where pname="+"'"+name+"'";
		   System.out.println(sql2);
		   rs1=stmt2.executeQuery(sql2);
		   int count=0;
		  if(rs1.next()){
			  count=rs1.getInt(1);
		  }
		  System.out.println(count);
		  count=count+num1;
		  System.out.println(count);
		  //更新历史购买量
		  sql2="update products set pcount ="+"'"+count+"'"+" where pname="+"'"+name+"'";
		  System.out.println(sql2);
		  stmt2.executeQuery(sql2);
		  
		  //将提交订单信息插入历史订单
		   String sql3="insert into historyorder values("+"'"+otime+"'"+","+"'"+user+"'"+","+"'"+name+"'"+","+"'"+type+"'"+","+"'"+price+"'"+","+"'"+num+"'"+")";
		   System.out.println(sql3);
		   Statement stmt3=conn.createStatement();
		   stmt2.executeQuery(sql3);
	   }
	   //把addorder表清空
	   String sql4="delete from addorder";
	   System.out.println(sql4);
	   stmt.executeQuery(sql4);
	   conn.close();
	   
    %>
	
	<script type="text/javascript" language="javascript">
		alert("提交订单成功!");
		window.document.location.href = "../shop.jsp";
	</script>


</body>

</html>
