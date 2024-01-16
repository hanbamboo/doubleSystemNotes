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

@WebServlet("/createBlog")
public class CreateBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			int uid = ((User) session.getAttribute("user")).getId();
			String uname = ((User) session.getAttribute("user")).getName();
			String title = request.getParameter("b_title");
			String context = request.getParameter("b_context");
			BlogSerivce blogSerivce = new BlogSerivce();
			boolean status = blogSerivce.createBlog(title, context, uid, uname);
			if (status) {
				response.sendRedirect("queryMyBlog");
			} else {
				response.sendRedirect("writeBlog");
			}
		} else {
			response.sendRedirect("login");
		}

	}

}
