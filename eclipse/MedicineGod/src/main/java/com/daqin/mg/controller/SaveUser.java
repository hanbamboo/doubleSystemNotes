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

@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		String u_lname = request.getParameter("u_lname");
		boolean userHas = userService.userHas(u_lname);
		HttpSession session = request.getSession();
		if (!userHas) {
			String u_sname = request.getParameter("u_sname");
			String u_pwd = request.getParameter("u_pwd");
			String u_phone = request.getParameter("u_phone");
			String u_mail = request.getParameter("u_mail");
			User user = new User();
			user.setLname(u_lname);
			user.setSname(u_sname);
			user.setPwd(u_pwd);
			user.setPhone(u_phone);
			user.setMail(u_mail);
			boolean status = userService.saveUser(user);
			if (status) {
				session.setAttribute("user", user);
				response.sendRedirect("login");
			}else {
				session.setAttribute("registerErrMsg", "注册失败,请重试");
				response.sendRedirect("RegisterErr");
			}
		} else {
			session.setAttribute("registerErrMsg", "用户已存在，请重新输入");
			response.sendRedirect("RegisterErr");
		}

	}

}
