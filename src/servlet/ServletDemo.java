package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet{

	private static final long serialVersionUID = -8269315383797561526L;
	
	@Override
	public void destroy() {
		System.out.println("servlet����");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet��ʼ��");
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
		
		printWrite(response);
	}

	//ʹ��printWriter�����
	private void printWrite(HttpServletResponse response) throws IOException {
		//ͨ��������Ӧͷ������������ı��뷽ʽ
		response.setHeader("content-type", "text/html; charset=UTF-8");
		
		String data = "���������Ͱɣ�";
	/*	�ڻ�ȡPrintWriter�����֮ǰ����ʹ��"response.setCharacterEncoding(charset)"
		�����ַ���ʲô���ı����������������磺response.setCharacterEncoding("UTF-8");
		���ý��ַ���"UTF-8"����������ͻ����������Ȼ����ʹ��response.getWriter();
		��ȡPrintWriter����������������費�ܵߵ� 		*/
		response.setCharacterEncoding("UTF-8");	//�����ַ���utf-8�ı�������������
		PrintWriter writer = response.getWriter();
		writer.write(data);
	}

	//ʹ��OutputStream�����
	private void streamWrite(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		//ͨ��������Ӧͷ������������ı��뷽ʽ
		response.setHeader("content-type", "text/html; charset=UTF-8");
		
		String a = "���ɸ�������";
		OutputStream out = response.getOutputStream();
		out.write(a.getBytes("UTF-8")); //ʹ��outputStream�������������ֽ�����
	}


	
	
}
