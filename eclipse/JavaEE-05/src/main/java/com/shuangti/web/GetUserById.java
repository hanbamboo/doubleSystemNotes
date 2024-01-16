package com.shuangti.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetUserById")
public class GetUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	浏览器发起请求传进id
//	servlet查询数据库获取用户名然后响应显示在页面上
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
//		假设查到名字是张三
//		把查询到的用户名转到jsp上去，让jsp来渲染
		request.setAttribute("id", id);
		request.setAttribute("name", "张三");
		request.getRequestDispatcher("next.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
