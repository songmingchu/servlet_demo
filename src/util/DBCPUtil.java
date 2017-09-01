package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class DBCPUtil {
	private static DataSource dataSource = null;
	
	static{
		try {
			//加载配置文件
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
			Properties properties = new Properties();
			properties.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取链接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//释放链接资源
	public void release(Connection connection, Statement statement, ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
} 
