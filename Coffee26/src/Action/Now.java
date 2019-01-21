package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Now {

	String username;// �˺�
	String password;// ����
	String name;// ����
	String tele;// �绰
	String mail;// ����
	String id;// ���(����Ա�����û�)

	// ���캯��
	public Now() {
		username = null;
		password = null;
		name = null;
		tele = null;
		mail = null;
		id = "U";// Ĭ�����û�
	}

	public Now(String u, String p, String n, String t, String m) {
		username = u;
		password = p;
		name = n;
		tele = t;
		mail = m;
	}

	// setter
	public void setUsername(String u) {
		username = u;
	}

	public void setPassword(String p) {
		password = p;
	}

	public void setName(String n) {
		name = n;
	}

	public void setTele(String t) {
		tele = t;
	}

	public void setMail(String m) {
		mail = m;
	}

	public void setId(String i) {
		id = i;
	}

	// getter
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getTele() {
		return tele;
	}

	public String getMail() {
		return mail;
	}

	public String getId() {
		return id;
	}

	// �ж��Ƿ���ڵ�ǰ�û�
	public boolean is_Have() throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from nowuser";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			flag = true;
			username = rs.getString(1);
			password = rs.getString(2);
			name = rs.getString(3);
			tele = rs.getString(4);
			mail = rs.getString(5);
			id = rs.getString(6);
		} else {
			flag = false;
		}
		conn.close();
		return flag;
	}

	// ɾ����ǰ�û�
	public void delete() throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "delete from nowuser";
		stmt.executeQuery(sql);
		conn.close();
	}

	// �ж��˺������Ƿ���ȷ,�����뵱ǰ�û�
	public boolean checkPass(String user, String pass) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql;
		if (id.equals("U"))
			sql = "select * from users where unumber ='" + user + "'and upassword ='" + pass + "'";
		else
			sql = "select * from administrators where anumber ='" + user + "'and apassword ='" + pass + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			flag = true;
			username = user;
			password = pass;
			name = rs.getString(3);
			tele = rs.getString(4);
			mail = rs.getString(5);
			sql = "delete from nowuser";
			stmt.executeQuery(sql);
			sql = "insert into nowuser values('" + user + "','" + pass + "','" + name + "','" + tele + "','" + mail
					+ "','" + id + "')";
			stmt.executeQuery(sql);
			conn.close();
		} else {
			flag = false;
		}
		return flag;
	}

	// �޸��û�������Ϣ(������)
	public void changeInfo(String n, String t, String m) throws ClassNotFoundException, SQLException {
		if (n != "")
			name = n;
		if (t != "")
			tele = t;
		if (m != "")
			mail = m;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql;
		if (id.equals("U"))
			sql = "update users set uname='" + name + "', utelephone='" + tele + "', umail='" + mail
					+ "'where unumber='" + username + "'";
		else
			sql = "update administrators set aname='" + name + "', atelephone='" + tele + "', amail='" + mail
					+ "'where anumber='" + username + "'";
		stmt.executeQuery(sql);
		sql = "update nowuser set nname='" + name + "', ntelephone='" + tele + "', nmail='" + mail + "'where nnumber='"
				+ username + "'";
		stmt.executeQuery(sql);
		conn.close();
	}

	// �޸��û�����

	// �޸��û�����
	public boolean changePass(String oldpass, String newpass) throws ClassNotFoundException, SQLException {
		if (!oldpass.equals(password))
			return false;
		password = newpass;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql;
		if (id.equals("U"))
			sql = "update users set upassword='" + password + "'where unumber='" + username + "'";
		else
			sql = "update administrators set apassword='" + password + "'where anumber='" + username + "'";
		stmt.executeQuery(sql);
		sql = "update nowuser set npassword='" + password + "'where nnumber='" + username + "'";
		stmt.executeQuery(sql);
		conn.close();
		return true;
	}

	// ע����
	public boolean checkRegi(String u, String p, String n, String t, String m)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from users where unumber ='" + u + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			conn.close();
			return false;
		} else {
			if (id.equals("U")) {
				username = u;
				password = p;
				name = n;
				tele = t;
				mail = m;

				sql = "delete from nowuser";
				stmt.executeQuery(sql);
				sql = "insert into nowuser values('" + username + "','" + password + "','" + name + "','" + tele + "','"
						+ mail + "','" + id + "')";
				stmt.executeQuery(sql);
				sql = "insert into users values('" + username + "','" + password + "','" + name + "','" + tele + "','"
						+ mail + "')";
				stmt.executeQuery(sql);
				conn.close();
				return true;
			} else {
				sql = "insert into users values('" + u + "','" + p + "','" + n + "','" + t + "','" + m + "')";
				stmt.executeQuery(sql);
				conn.close();
				return true;
			}
		}
	}

	// ����Ա��ȡ�����û�
	public ArrayList<Now> getAllUsers() throws ClassNotFoundException, SQLException {
		ArrayList<Now> allusers = new ArrayList<Now>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "select * from users";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Now u = new Now();
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));
			u.setName(rs.getString(3));
			u.setTele(rs.getString(4));
			u.setMail(rs.getString(5));
			allusers.add(u);
		}
		conn.close();
		return allusers;
	}

	// ����Աɾ��һ���û�
	public void deleteUser(int i) throws ClassNotFoundException, SQLException {
		Now n = new Now();
		n.is_Have();
		ArrayList<Now> allusers = new ArrayList<Now>();
		allusers = n.getAllUsers();
		String user = allusers.get(i).getUsername();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "delete from users where unumber='" + user + "'";
		stmt.executeQuery(sql);
		conn.close();
	}

	// ����Ա�޸�һ���û���Ϣ (����Ҫ�޸�)
	public void changeUser(int i, String n, String t, String m) throws ClassNotFoundException, SQLException {
		Now now = new Now();
		ArrayList<Now> allusers = new ArrayList<Now>();
		allusers = now.getAllUsers();
		String user = allusers.get(i).getUsername();

		username = allusers.get(i).getUsername();

		name = allusers.get(i).getName();
		tele = allusers.get(i).getTele();
		mail = allusers.get(i).getMail();
		if (n != "")
			name = n;
		if (t != "")
			tele = t;
		if (m != "")
			mail = m;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orac", "baddie", "947312014");
		Statement stmt = conn.createStatement();
		String sql = "update users set uname='" + name + "', utelephone='" + tele
				+ "', umail='" + mail + "'where unumber='" + username + "'";
		stmt.executeQuery(sql);
		conn.close();
	}
}
