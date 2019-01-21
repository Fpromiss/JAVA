package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Product {

	String pName;// ��Ʒ����
	String pType;// ��Ʒ����
	int pStock;// ��Ʒ����
	int pPrice;// ��Ʒ�۸�
	int pCount;// ��Ʒ�ȶ�
	String pRoute;// ��ƷͼƬ·��
	Connection conn;
	Statement stmt;
	ResultSet rs;

	// ���캯��
	public Product() throws ClassNotFoundException, SQLException {

		pName = null;
		pType = null;
		pStock = 0;
		pPrice = 0;
		pRoute = null;
		pCount = 0;
	}

	public Product(String name, String type, int stock, int price, String route)
			throws SQLException, ClassNotFoundException {

		pName = name;
		pType = type;
		pStock = stock;
		pPrice = price;
		pRoute = route;
		
		
		pCount = 0;
	}

	// setter
	public void set_Name(String name) {
		pName = name;
	}

	public void set_Type(String type) {
		pType = type;
	}

	public void set_Stock(int stock) {
		pStock = stock;
	}

	public void set_Price(int price) {
		pPrice = price;
	}

	public void set_Route(String route) {
		pRoute = route;
	}

	public void set_Count(int count) {
		pCount = count;
	}

	// getter
	public String get_Name() {
		return pName;
	}

	public String get_Type() {
		return pType;
	}

	public int get_Stock() {
		return pStock;
	}

	public int get_Price() {
		return pPrice;
	}

	public String get_Route() {
		return pRoute;
	}

	public int get_Count() {
		return pCount;
	}

	// �������ݵ����ݿ�
	public int Insert2Database() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		stmt = conn.createStatement();
		String sql = "insert into products values('" + pName + "','" + pType + "'," + pStock + "," + pPrice + ",'"
				+ pRoute + "'," + pCount + ")";
		return stmt.executeUpdate(sql);
	}

	// �������ݵ����ݿ�
	public void Update2Database() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		stmt = conn.createStatement();
		String sql = "update products set ptype=" + "'" + pType + "'" + ", pstock=" + pStock + ", pprice=" + pPrice
				+ ", proute=" + pRoute + "where pname='" + pName+"'";
		stmt.executeQuery(sql);
		conn.close();
	}

	// �����ݿ�ɾ����Ϣ
	public void DropFromDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		stmt = conn.createStatement();
		String sql = "delete from products where pname='" + pName+"'";
		stmt.executeQuery(sql);
		conn.close();
	}

	// ������ɸѡ
	public boolean SelectWithName(String name) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		stmt = conn.createStatement();
		String sql = "select * from products where pname='" + name+"'";
		stmt.executeQuery(sql);
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			pName = rs.getString(1);
			pType = rs.getString(2);
			pStock = rs.getInt(3);
			pPrice = rs.getInt(4);
			pRoute = rs.getString(5);
			pCount = rs.getInt(6);
			conn.close();
			return true;
		}
		conn.close();
		return false;
	}

	// ɾ����Ʒ
	public void deleteProduct(int i) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		stmt = conn.createStatement();

		ArrayList<Product> allpruduct = new ArrayList<Product>();
		Administrator admin = new Administrator();
		allpruduct = admin.SelectAllProducts();
		String name = allpruduct.get(i).get_Name();

		String sql = "delete from products where pname='" + name + "'";
		stmt.executeUpdate(sql);
		conn.close();
	}

}
