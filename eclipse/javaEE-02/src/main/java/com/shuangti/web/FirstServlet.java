package com.shuangti.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * implements是关键字，用来实现接口
 * Servlet是tomcat的核心接口，实现了此核心接口的类，就能处理响应了
 * 接口就是开发者定义好的一套标准，实现此接口的类就被认为
 * 给他打了一个标签，后续java运行的时候会按照固定的模式去运行它
 * 比如：某一个接口定义了飞行的方法，后边有一个鸟实现了这个接口，
 * 那java运行的时候就会认为鸟具有飞行的能力
 * 
 * FirstServlet实现了Servlet接口后必须要将所有的方法
 * 进行重写
 */
public class FirstServlet implements Servlet {
	public FirstServlet() {
		System.out.println("servlet对象被创建");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet销毁");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet初始化");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("servlet处理请求");

	}

}
