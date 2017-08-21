package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	private static final String url = "jdbc:mysql://localhost:3306/servlet_demo";
	private static final String username = "root";
	private static final String password = "maxiaomengzz";
	
	public static void insert() throws ClassNotFoundException, SQLException {
		//获取驱动
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement statement = conn.createStatement();
		
		String sql = "insert into user (username, name, password) value ('song', 'song', '111111')";
		int ca = statement.executeUpdate(sql);
		if(ca > 0) {
			System.out.println("数据库插入成功");
		}
		
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		insert();
	}
}
