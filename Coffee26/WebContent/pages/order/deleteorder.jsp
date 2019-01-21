<%@ page language="java" import="java.sql.*,Action.*,java.util.ArrayList"
	contentType="text/html;charset=utf-8"%>

<!--                 删除菜单                                    -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title>删除菜单</title>

</head>

<body>

	<%
	//设置编码方式
		request.setCharacterEncoding("utf-8");
	 //获取添加下标
	String i=request.getParameter("i");
    int j=Integer.parseInt(i);//获取下标
    //创建一个管理员对象 用于获取所有信息
    Administrator admin =new Administrator();
    ArrayList<Product> array = new ArrayList<Product>();
	array=admin.SelectAllProducts();//获取所有菜品信息
    Product p = new Product();
    p=array.get(j);//获取当前菜品信息
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
    //获取数量
    String sql="select oamount from addorder where oname ="+"'"+p.get_Name()+"'";
    System.out.println(sql);
    rs =stmt.executeQuery(sql);
    int flag=0;//标记是否成功
    if(rs.next()){
    	String num=rs.getString(1);
    	int number=Integer.parseInt(num);
    	if(number>1){//如果数量大于1 说明可以-1 进行更新操作
    		number=number-1;
    		String sql1="update addorder set oamount ="+"'"+String.valueOf(number)+"'"+" where oname="+"'"+p.get_Name()+"'"+" and ouser="+"'"+nuser+"'";
    		System.out.println(sql1);
    		stmt.executeQuery(sql1);
    		flag=1;//标记成功
    	}
    	else{//如果数量小于1 直接删除该产品从addorder表
    		String sql2="delete from addorder where oname="+"'"+p.get_Name()+"'"+" and ouser="+"'"+nuser+"'";
    		System.out.println(sql2);
    		stmt.executeQuery(sql2);
    		flag=1;
    	}
    }
    conn.close();//关闭连接
	
		if(flag==1){//如果删除成功
	%>

	<script type="text/javascript" language="javascript">
		alert("成功从购物车中删除!");
		window.document.location.href = "../Menu.jsp";
	</script>
     <%
		}else{//如果删除失败 
     %>
     <script type="text/javascript" language="javascript">
		alert("购物车中删除失败!");
		window.document.location.href = "../Menu.jsp";
	</script>
    <%
		}
    %>
     
</body>

</html>
