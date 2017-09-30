package annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
	@AnnoJdbc(password = "maxiaomengzz", url = "jdbc:mysql://localhost:3306/servlet_demo")
	public static Connection getConnection() throws Exception {
		//获取字节码对象
		Class clazz = JDBCUtil.class;
		//获取方法对象
		Method mthod = clazz.getMethod("getConnection");
		
		if(mthod.isAnnotationPresent(AnnoJdbc.class)) {
			//获取链接参数
			AnnoJdbc annotation = mthod.getAnnotation(AnnoJdbc.class);
			String driverClass = annotation.driverClass();
			String url = annotation.url();
			String username = annotation.username();
			String password = annotation.password();
			//获取链接
			Class.forName(driverClass);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return null;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection().toString());
	}
}
