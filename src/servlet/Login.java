package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBCPUtil;

public class Login extends HttpServlet{

	private static final long serialVersionUID = 129509529672956551L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应头，控制浏览器以指定的字符编码编码进行显示
		response.setHeader("content-type", "text/html;charset=UTF-8");
		//设置将字符以"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//校验密码
		try {
			Connection connection = DBCPUtil.getConnection();
			String sql = "select * from user where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
			String pwd = null;
			while(resultSet.next()) {
				pwd = resultSet.getString("password");
			}
			
			if(pwd != null && pwd.equals(password)) {
				System.out.println("登录成功");
				request.getRequestDispatcher("/portal/home.jsp").forward(request, response);
			}else{
				System.out.println("用户名或密码错误");
				PrintWriter writer = response.getWriter();
				writer.write("用户名或密码错误");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	

}
