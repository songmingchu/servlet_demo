package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet{

	private static final long serialVersionUID = -8269315383797561526L;
	
	@Override
	public void destroy() {
		System.out.println("servlet销毁");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化");
		super.init();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service_HttpServletRequest");
		super.service(arg0, arg1);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//streamWrite(response);
		
		//printWrite(response);
		
		//downloadFile(response);
	}

	//下载文件，注意使用字节流而不是字符流
	private void downloadFile(HttpServletResponse response)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		//获取要下载的文件
		String realPath = this.getServletContext().getRealPath("/static/songsong.jpg");	//获取文件的绝对路径
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1); //获取文件的文件名
		
		//设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码
		response.setHeader("content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));
		
		InputStream in = new FileInputStream(realPath);
		int len = 0;
		byte[] arr = new byte[1024];
		OutputStream out = response.getOutputStream();
		while ((len = in.read(arr)) > 0) {
			out.write(arr, 0, len);
		}
		in.close();
	}

	//使用printWriter流输出
	private void printWrite(HttpServletResponse response) throws IOException {
		//通过设置响应头，控制浏览器的编码方式
		response.setHeader("content-type", "text/html; charset=UTF-8");
		
		String data = "明初，加油吧！";
	/*	在获取PrintWriter输出流之前首先使用"response.setCharacterEncoding(charset)"
		设置字符以什么样的编码输出到浏览器，如：response.setCharacterEncoding("UTF-8");
		设置将字符以"UTF-8"编码输出到客户端浏览器，然后再使用response.getWriter();
		获取PrintWriter输出流，这两个步骤不能颠倒 		*/
		response.setCharacterEncoding("UTF-8");	//设置字符以utf-8的编码输出到浏览器
		PrintWriter writer = response.getWriter();
		writer.write(data);
	}

	//使用OutputStream流输出
	private void streamWrite(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		//通过设置响应头，控制浏览器的编码方式
		response.setHeader("content-type", "text/html; charset=UTF-8");
		
		String a = "自律给人自由";
		OutputStream out = response.getOutputStream();
		out.write(a.getBytes("UTF-8")); //使用outputStream流向浏览器输出字节数组
	}


	
	
}
