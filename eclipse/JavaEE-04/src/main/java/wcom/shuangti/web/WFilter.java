package wcom.shuangti.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * WebFilter是过滤器的注解
 * "/*"是代表过滤所有的请求
 * "*.do"可以过滤地址以do结尾的所有请求
 */
@WebFilter("*.do")
public class WFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * doFilter是过滤器的核心方法，起到过滤功能 
	 * 所有的过滤功能实现，都在这
	 * 
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("只要是请求，都得先我这里");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
