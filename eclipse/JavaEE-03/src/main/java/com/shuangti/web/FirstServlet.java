package com.shuangti.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.Utf8Encoder;

/*
 * 1.HttpServlet是间接实现了Servlet接口
 * 2.Servlet接口的一些抽象方法（没有方法体的方法）是在父类当中已经实现了
 * 3.FirstServlet自己创建的这个类
 * 只需要重写一下父类当中的doGet、doPost就可以用来处理请求l
 * 		什么是请求？
 * 			浏览器输入地址回车就是发起一个请求
 * 			网页上链接点击就是发起一个请求
 * 			form表单，点击提交按钮，提交action就是请求
 * 		doGet、doPost是可以来处理不同请求方式的方法
 * 4.doGet、doPost方法当中都有两个形参，
 * 		一个是request（请求），一个是response（响应）
 * 			request可以用来接收客户端发起的请求数据
 * 			response可以用来响应数据给到客户端
 * 5.注解 @WebServlet("/FirstServlet")
 * 			相当于在web.xml里面配置了Servlet映射

 */
//第一种最常用
@WebServlet("/index.html")
//@WebServlet(name="TestServlet",urlPatterns = {"/test1","test2"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		System.out.println("get请求过来了");
		System.out.println(uname);
		
		
		/*
		 * 假设用户为张三响应成功，否则失败		
		 * 通过response获取一个流对象，通过流对象发送给客户端做出响应

		 */
		PrintWriter pt = response.getWriter();
		if(uname.equals("张三")) {
//			响应给客户端数据：成功
			
			pt.write("success!");
		}else {
			pt.write("error!");
//			响应失败
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("uname"));
		
	}

}
