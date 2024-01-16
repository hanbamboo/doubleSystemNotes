package com.shuangti.blog.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shuangti.blog.entity.Blog;
import com.shuangti.blog.service.BlogSerivce;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO:查询数据获取所有用户博客列表
		// 将所有数据放到数组中，存到request当中
		
		BlogSerivce blogSerivce = new BlogSerivce();
		ArrayList<Blog> blogs =  blogSerivce.queryAllBlogs();
		HttpSession session = request.getSession();
		session.setAttribute("blog", blogs);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
