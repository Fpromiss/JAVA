package Action;

import java.sql.*;

public class User {
	
	String uNumber;//账号名
	String uPassword;//密码
	String uName;//名字
	String uTelephone;//电话
	String uMail;//邮箱
	ResultSet rs;
	
	//构造函数
	public User() throws ClassNotFoundException, SQLException
	{
		//初始化数据
		uNumber=null;
		uPassword=null;
		uName=null;
		uTelephone=null;
		uMail=null;
	}
	
	public User(String number,String password,String name,String telephone,String mail) throws ClassNotFoundException, SQLException
	{
		uNumber=number;
		uPassword=password;
		uName=name;
		uTelephone=telephone;
		uMail=mail;
	}
	
	//setter
	public void set_Number(String number)
	{
		uNumber=number;
	}
	public void set_Password(String password)
	{
		uPassword=password;
	}
	public void set_Name(String name)
	{
		uName=name;
	}
	public void set_Telephone(String telephone)
	{
		uTelephone=telephone;
	}
	public void set_Mail(String mail)
	{
		uMail=mail;
	}
	
	//getter
	public String get_Number()
	{
		return uNumber;
	}
	public String get_Password()
	{
		return uPassword;
	}
	public String get_Name()
	{
		return uName;
	}
	public String get_Telephone()
	{
		return uTelephone;
	}
	public String get_Mail()
	{
		return uMail;
	}	
	
	//对数据库内自身数据的增删改查
	public void Insert2Database() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "insert into users values(" + "'" + uNumber + "'" + "," + "'" + uPassword + "'" + "," + "'" + uName
				+ "'" + "," + "'" + uTelephone + "'" + "," + "'" + uMail + "'" + ")";
		stmt.executeQuery(sql);
		conn.close();
	}

	public void Update2Database() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "update users set upassword=" + "'" + uPassword + "'" + ",uname=" + "'" + uName + "'"
				+ ", utelephone=" + "'" + uTelephone + "'" + ", umail=" + "'" + uMail + "'" + "where unumber=" + "'"
				+ uNumber + "'";
		stmt.executeQuery(sql);
		conn.close();
	}

	public void DropFromDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "delete from users where unumber=" + "'" + uNumber + "'";
		stmt.executeQuery(sql);
		conn.close();
	}
	
	public void SelectFromDatabase(String number) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from users where unumber=" + "'" + number + "'";
		stmt.executeQuery(sql);
		rs = stmt.executeQuery(sql);
		
		uNumber = rs.getString(1);
		uPassword = rs.getString(2);
		uName = rs.getString(3);
		uTelephone = rs.getString(4);
		uMail = rs.getString(5);
		conn.close();
	}
	
	
	//检查用户名和密码是否匹配
	public boolean Check(String number, String name) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from users where unumber=" + "'" + number + "'";
		stmt.executeQuery(sql);
		rs = stmt.executeQuery(sql);
		if (uPassword.equals(rs.getString(2))) {
			uNumber = rs.getString(1);
			uPassword = rs.getString(2);
			uName = rs.getString(3);
			uTelephone = rs.getString(4);
			uMail = rs.getString(5);
			conn.close();
			return true;
		}
		conn.close();
		return false;
	}
	
}
