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
import com.shuangti.blog.entity.User;
import com.shuangti.blog.service.BlogSerivce;
import com.shuangti.blog.service.UserSerivce;


@WebServlet("/myBlog")
public class MyBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BlogSerivce blogSerivce = new BlogSerivce();
		if (session.getAttribute("user")==null) {
			response.sendRedirect("login");
		}else {
			int uid = ((User)session.getAttribute("user")).getId();
			ArrayList<Blog> blogs =  blogSerivce.queryMyBlogs(uid);
			System.out.println(blogs.size());
			session.setAttribute("blog", blogs);
			request.getRequestDispatcher("myBlog.jsp").forward(request, response);
		}
		
	}

	

}
