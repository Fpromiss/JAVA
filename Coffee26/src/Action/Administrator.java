package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Administrator {
	
	String aNumber;//账号名
	String aPassword;//密码
	String aName;//名字
	String aTelephone;//电话
	String aMail;//邮箱
	
	//构造函数
	public Administrator() throws ClassNotFoundException, SQLException
	{
		//初始化数据
		aNumber=null;
		aPassword=null;
		aName=null;
		aTelephone=null;
		aMail=null;
	}
	
	public Administrator(String number,String password,String name,String telephone,String mail) throws ClassNotFoundException, SQLException
	{

		//初始化数据
		aNumber=number;
		aPassword=password;
		aName=name;
		aTelephone=telephone;
		aMail=mail;
	}
	
	//setter
	public void set_Number(String number)
	{
		aNumber=number;
	}
	public void set_Password(String password)
	{
		aPassword=password;
	}
	public void set_Name(String name)
	{
		aName=name;
	}
	public void set_Telephone(String telephone)
	{
		aTelephone=telephone;
	}
	public void set_Mail(String mail)
	{
		aMail=mail;
	}
	
	//getter
	public String get_Number()
	{
		return aNumber;
	}
	public String get_Password()
	{
		return aPassword;
	}
	public String get_Name()
	{
		return aName;
	}
	public String get_Telephone()
	{
		return aTelephone;
	}
	public String get_Mail()
	{
		return aMail;
	}	

	//对数据库内管理员自身的增删改查操作
	//插入数据到数据库
	public void Insert2Database() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "insert into administrators values(" + "'" + aNumber + "'" + "," + "'" + aPassword + "'" + "," + "'" + aName
				+ "'" + "," + "'" + aTelephone + "'" + "," + "'" + aMail + "'" + ")";
		stmt.executeQuery(sql);
		conn.close();
	}

	//更新数据到数据库
	public void Update2Database() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "update administrators set apassword=" + "'" + aPassword + "'" + ",aname=" + "'" + aName + "'"
				+ ", atelephone=" + "'" + aTelephone + "'" + ", amail=" + "'" + aMail + "'" + "where anumber=" + "'"
				+ aNumber + "'";
		stmt.executeQuery(sql);
		conn.close();
	}

	//从数据库删除
	public void DropFromDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "delete from administrators where anumber=" + "'" + aNumber + "'";
		stmt.executeQuery(sql);
		conn.close();
	}
	
	//查找管理员
	public void SelectFromDatabase(String number) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from administrators where anumber=" + "'" + number + "'";
		stmt.executeQuery(sql);
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			aNumber = rs.getString(1);
			aPassword = rs.getString(2);
			aName = rs.getString(3);
			aTelephone = rs.getString(4);
			aMail = rs.getString(5);
		}
		conn.close();
	}
	
	//检查用户名和密码是否匹配
	public boolean Check(String number,String name) throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from administrators where anumber=" + "'" + number + "'";
		stmt.executeQuery(sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		return aPassword.equals(rs.getString(2));
	}
	
	//对数据库内用户的增删改查操作
	//查找所有用户
	public ArrayList<User> SelectAllUsers() throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		ArrayList<User> allusers = new ArrayList<User>();
		String sql = "select * from users";
		stmt.executeQuery(sql);
		ResultSet rs = stmt.executeQuery(sql);
		
		//循环从数据库提取每一个用户的信息
		while (rs.next()) {
			User u = new User();
			u.set_Number(rs.getString(1));
			u.set_Password(rs.getString(2));
			u.set_Name(rs.getString(3));
			u.set_Telephone(rs.getString(4));
			u.set_Mail(rs.getString(5));
			allusers.add(u);
		}
		conn.close();
		return allusers;
	}
	
	//增加一个用户
	public void InsertUser(User u) throws SQLException, ClassNotFoundException
	{
		u.Insert2Database();
	}
	
	//删除一个用户
	public void DeleteUser(User u) throws SQLException, ClassNotFoundException
	{
		u.DropFromDatabase();
	}
	
	//修改一个用户
	public void UpdateUser(User u) throws SQLException, ClassNotFoundException
	{
		u.Update2Database();
	}
	
	//查询一个用户
	public User SelectOneUser(String number) throws ClassNotFoundException, SQLException
	{
		User u =new User();
		u.SelectFromDatabase(number);
		return u;
	}
	
	//对数据库内菜单的增删改查操作
	//增加一个产品
	public void InsertProduct(Product p) throws SQLException, ClassNotFoundException
	{
		p.Insert2Database();
	}
	
	//修改一个产品
	public void UpdateProduct(Product p) throws SQLException, ClassNotFoundException
	{
		p.Update2Database();
	}
	
	//删除一个产品
	public void DeleteProduct(Product p) throws SQLException, ClassNotFoundException
	{
		p.DropFromDatabase();
	}

	//查询一个产品  按名字
	public Product SelectProduct_Name(String name) throws ClassNotFoundException, SQLException
	{
		Product p = new Product();
		p.SelectWithName(name);
		return p;
	}
	
	//查询一组产品  按照类型筛选
	public ArrayList<Product> SelectProduct_Type(String Type) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from products where ptype='" + Type+"'";
		stmt.executeQuery(sql);
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Product> a = new ArrayList<Product>();
	
		while(rs.next())
		{
			Product p = new Product();
			p.set_Name(rs.getString(1));
			p.set_Type(rs.getString(2));
			p.set_Stock(rs.getInt(3));
			p.set_Price(rs.getInt(4));
			p.set_Route(rs.getString(5));
			p.set_Count(rs.getInt(6));
			a.add(p);
		}
		conn.close();
		return a;
	}
	
	//查询所有产品
	public ArrayList<Product> SelectAllProducts() throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from products order by pcount desc";
		stmt.executeQuery(sql);
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Product> a = new ArrayList<Product>();
	
		while(rs.next())
		{
			Product p = new Product();
			p.set_Name(rs.getString(1));
			p.set_Type(rs.getString(2));
			p.set_Stock(rs.getInt(3));
			p.set_Price(rs.getInt(4));
			p.set_Route(rs.getString(5));
			p.set_Count(rs.getInt(6));
			a.add(p);
		}
		conn.close();
		return a;
	}

}
