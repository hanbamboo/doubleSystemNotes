package com.shuangti.blog.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 过滤相关的功能，写在doFilter方法里
		// 判断当前请求路径是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		// 放过此请求
		if (uri.contains("home") || uri.contains("login") || uri.contains("saveUser") || uri.contains("checkUser")
				|| uri.contains("register")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			if (session != null && session.getAttribute("user") != null) {
				chain.doFilter(request, response);
			} else {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect("login");
			}
		}

	}

	@Override
	public void destroy() {

	}

}
