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

@WebServlet("/delBlog")
public class DelBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			int blogId = Integer.parseInt(request.getParameter("id"));
			BlogSerivce blogSerivce = new BlogSerivce();
			boolean status = blogSerivce.delMyBlogs(blogId);
			if (status) {
				ArrayList<Blog> blogs = blogSerivce.queryMyBlogs(user.getId());
				session.setAttribute("blog", blogs);
				request.getRequestDispatcher("myBlog.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("login");
		}

	}

}
