<%@ page language="java" import="java.sql.*,Action.*,java.util.ArrayList"
	contentType="text/html;charset=utf-8"%>

<!--                 用户菜单界面添加商品功能实现                                    -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户菜单界面添加商品功能实现  </title>
</head>
<body>

	<%
	    //设置编码方式
		request.setCharacterEncoding("utf-8");
	    //获取添加下标
    	String i=request.getParameter("i");
	    int j=Integer.parseInt(i);
	    //创建一个管理员临时对象 ，用于获取数据库中所有菜品信息
	    Administrator admin =new Administrator();
	    //创建一个arraylist，元素类型为产品类型 ，用于接收所有产品的信息
	    ArrayList<Product> array = new ArrayList<Product>();
	    //调用方法：SelectAllProducts()，获取所有菜品信息
    	array=admin.SelectAllProducts();
	    //创建一个产品类型变量 ，用户获取当前菜品 ，通过下标j获取
	    Product p = new Product();
	    //获取当前菜品对象
	    p=array.get(j);
	    //连接数据库
	    Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
	    //获取当前用户名
	    String sql="select nnumber from nowuser";
	    //执行sql语句
	    ResultSet rs =stmt.executeQuery(sql);
	    //nuser存放当前登陆用户的用户名
	    String nuser="";
	    //如果if条件成立 说明此时用户登陆了 
	    if(rs.next()){
	    	//那么获取用户当前用户用户名，存放在变量nuser中
	    	nuser=rs.getString(1);
	    }    
	    //判断库存量
		int k=1;
	    //从当前存放订单的表addorder中去查询是否有当前用户添加过当前商品
	    String sql1="select * from addorder where ouser="+"'"+nuser+"'"+" and oname="+"'"+p.get_Name()+"'";
	    //System.out.println(sql1);
	    //执行sql1
		rs=stmt.executeQuery(sql1); 
		//如果查询有结果，说明本来添加过当前商品 那么进行更新
		if(rs.next()){
			k=k+ Integer.parseInt(rs.getString(5));
			String sql2="update addorder set oamount="+"'"+String.valueOf(k)+"'"+" where ouser="+"'"+nuser+"'"+" and oname="+"'"+p.get_Name()+"'";
			System.out.println(sql2);
			 stmt.executeQuery(sql2); 
		}
	    //该菜品没有添加过 直接插入数据库
	    else{
	      String sql3 = "insert into addorder values (" + "'" + nuser + "'" + "," + "'" + p.get_Name() + "'" + "," + "'" + p.get_Type()
				+ "'" + "," + "'" + String.valueOf(p.get_Price()) + "'" + "," + "'" + String.valueOf(k) + "'" + ")";
	      System.out.println(sql3);
		  stmt.executeQuery(sql3); 
	    }
		conn.close();//关闭连接
	%>

	<script type="text/javascript" language="javascript">
		alert("添加菜单成功!");
		window.document.location.href = "../Menu.jsp";
	</script>


</body>

</html>
