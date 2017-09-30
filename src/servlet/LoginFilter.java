package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、判断用户是否已经登录
 * 2、当用户用新的客户端登录时，旧的客户端自动注销
 * 3、设置登录有效时长
 * 4、设置编码为utf-8
 * @author songm
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化登录过滤器");
	}
	
	@Override
	public void destroy() {
		System.out.println("销毁登录过滤器");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		System.out.println("-------------> 过滤器转码");
		
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("txt/html; charset=utf-8");
		EcodingRequest ecodingRequest = new EcodingRequest(request);
		
		
		//调用servlet
		chain.doFilter(ecodingRequest, response);
	}

	
	
	//利用装饰模式来包装request
	class EcodingRequest extends HttpServletRequestWrapper{
		
		private HttpServletRequest request;

		public EcodingRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		//重写getParameter方法
		public String getParameter(String name) {
			String parameter = this.request.getParameter(name);
			if(parameter == null) {
				return null;
			}
			
			//判断请求方式
			if(!this.request.getMethod().equalsIgnoreCase("get")) {
				return parameter;
			}else {
				try {
					return new String(parameter.getBytes("ISO8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	
	
}
