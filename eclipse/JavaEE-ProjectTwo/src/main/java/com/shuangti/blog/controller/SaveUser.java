package com.shuangti.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shuangti.blog.entity.User;
import com.shuangti.blog.service.UserSerivce;

/*
 * 注册进数据库
 * 成功就返回主页
 */
@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_name = request.getParameter("u_name");
		String u_pwd = request.getParameter("u_pwd");
		String u_phone = request.getParameter("u_phone");
		String u_email = request.getParameter("u_mail");
//		Integer.parseInt(u_phone);可以强转数字

		// 链接数据库，保存用户
		// 1.调用service中的saveUser
		// 2.saveUser调用daoceng的UserDao中insertUser方法
		// 3.insertUser通过JDBC链接数据库
		// 4.最终saveUser返回个boolean值，如果是true，跳转至博客首页
		// 如果是false，跳转回注册页
		User user = new User();
		user.setName(u_name);
		user.setPwd(u_pwd);
		user.setPhone(u_phone);
		user.setEmai(u_email);
		UserSerivce userSerivce = new UserSerivce();
		boolean flag = userSerivce.saveUser(user);
		if (flag) {
			// 转发至首页home
//			request.getRequestDispatcher("home.jsp").forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("home");
		} else {
			// 停留在注册页register
//			request.getRequestDispatcher("register.jsp").forward(request, response);
			response.sendRedirect("register");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
