package com.shuangti.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 转发和重定向的区别：
 * 		1.（请求）转发：浏览器其实是发起了一次请求
 * 			后端servlet会将浏览器请求响应转到另一个servlet
 * 			对于浏览器来说是无感知的，就是一次请求。
 * 		2.（响应）重定向：浏览器发起请求到servlet，servlet给出响应response
 * 			通过response告诉浏览器，让浏览器重新发起了另一个请求到
 * 			要重定向的servlet，其实相当于前后两次请求。
 * 		3.转发可以将请求数据完整的转到另一个servlet
 * 		  重定向因为请求发起两次的原因，第二次重定向的请求并没有
 * 			把第一次请setAttribute求的request对象传递给第二个servlet，会导致数据丢失
 * 		4.request中可以使用setAttribute和getAttribute进行存值取值
 * 			后续jsp中用的多
*/
@WebServlet("/LiSiServlet")
public class LiSiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 张三找李四借1000块
	// 借1000块式一个请求request
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * @转发(一次请求)
		 */
		// System.out.println("LiSi没钱，我去找LaoWang");
		// 李四再去帮你找老王1000元
		// 把借1000块的请求给到老王
		request.setAttribute("say", "过几天就还你");
		String money = request.getParameter("money");
		System.out.println("借钱："+money);
		 request.getRequestDispatcher("LaoWangServlet").forward(request, response);
		
		/**
		 * @重定向(两次请求)
		 */
		// 李四告诉你没钱，你去找老王1000元
		// 把借1000块的请求给到老王
//		String money = request.getParameter("money");
//		System.out.println("借钱："+money);
//		System.out.println("LiSi没钱，你去找LaoWang");
//		response.sendRedirect("LaoWangServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
