package com.daqin.mg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daqin.mg.entity.User;
import com.daqin.mg.service.UserService;

@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String u_lname = request.getParameter("u_lname");
		String u_pwd = request.getParameter("u_pwd");
		UserService userService = new UserService();
		User user = userService.checkUser(u_lname, u_pwd);
		if (user != null) {
			session.setAttribute("user", user);
			response.sendRedirect("home");
		} else {
			session.setAttribute("loginErrMsg", "用户密码错误或不存在，请重新输入");
			response.sendRedirect("LoginErr");

		}
	}

}
