<%@ page language="java" import="java.sql.*,Action.*"
	contentType="text/html;charset=utf-8"%>

<!--                 修改菜单                                    -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<title> 修改菜单  </title>

</head>

<body>

	<%
	//设置编码方式
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("newname");//获取名称
		String type = request.getParameter("newtype");//获取类型
		String stock = request.getParameter("newstock");//获取库存
		String price= request.getParameter("newprice");//获取价格
		Product p=new Product();
		//链接数据库
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		//获取当前产品
		String sql0="select * from nproduct";
		ResultSet rs=stmt.executeQuery(sql0);
		//设置一个默认值
		String nname="2018";
		String ntype="2018";
		int nstock=2018;
		int nprice=2018;
		String nroute="2018";
		int mystock=2018;
		int myprice=2018;
		int ncount = 0;
		//赋值
		while(rs.next()){
			nname=rs.getString(1);
			ntype=rs.getString(2);
			nstock=rs.getInt(3);
			nprice=rs.getInt(4);
			nroute=rs.getString(5);
			ncount = rs.getInt(6);
		}
		int flag=0;//标记是否修改名称
		if(name==""){
		    name=nname;
		}
		else if(name.equals(nname)){
			flag=1;
		}//判断是否修改为空
		if(type==""){
			type=ntype;
		}
		if(stock==""){
			mystock=nstock;
		}else{
			mystock= Integer.parseInt(stock);
		}
		if(price==""){
			myprice=nprice;  
		}else{
			myprice= Integer.parseInt(price);
		}
		//如果没有修改名称 直接更新
		if(flag==1){
			String sql1 = "update products set ptype=" +"'" + type + "'"
					+ ", pstock=" +"'" +mystock +"'"+ ", pprice=" + "'"+myprice +"'"+", proute='" + nroute + "' where pname=" +"'" +nname+"'";
			stmt.executeUpdate(sql1);
			
			String sql2="update nproduct set nname=2018";
			stmt.execute(sql2);
			flag=0;
		}
		else{//如果修改了名称 先删除原来的 再插入
			String sql="delete from products where pname="+"'"+nname+"'";

			stmt.executeUpdate(sql);
			String sql1="insert into products values('" + name + "','" + type
					+ "'," + mystock + "," + myprice + ",'"+nroute+"',"+ncount+")";

			stmt.executeUpdate(sql1);
			flag=0;
		}
		
		conn.close();
	%>

	<script type="text/javascript" language="javascript">
		alert("修改信息成功!");
		window.document.location.href = "../ManagementOfMenu.jsp";
	</script>
     
     <%
     if(name==""&&type==""&&stock==""&&price==""){
    	 %>
      	 <script type="text/javascript" language="javascript">
		alert("修改信息失败!");
		window.document.location.href = "../Adminimenu.jsp";
	</script>
     <% 
     }
     %>
     
</body>

</html>
