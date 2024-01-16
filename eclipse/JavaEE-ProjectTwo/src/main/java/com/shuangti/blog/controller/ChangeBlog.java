package com.shuangti.blog.controller;

import java.io.IOException;
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

@WebServlet("/changeBlog")
public class ChangeBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int blogId = Integer.parseInt(request.getParameter("id"));
		String b_title = request.getParameter("b_title");
		String b_context = request.getParameter("b_context");
		BlogSerivce blogSerivce = new BlogSerivce();
		boolean status = blogSerivce.changeBlog(blogId, b_title, b_context);
		if (status) {
			response.sendRedirect("home");
		} else {
			response.sendRedirect("editBlog");
		}
	}

}
