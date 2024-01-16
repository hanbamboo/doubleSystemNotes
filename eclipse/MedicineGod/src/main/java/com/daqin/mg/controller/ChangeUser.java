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

@WebServlet("/changeUser")
public class ChangeUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			String sname = request.getParameter("u_sname");
			String pwd = request.getParameter("u_pwd");
			String phone = request.getParameter("u_phone");
			String mail = request.getParameter("u_mail");
			user.setSname(sname);
			user.setPhone(phone);
			user.setPwd(pwd);
			user.setMail(mail);
			UserService userService = new UserService();
			boolean flag = userService.changeUser(user);
			if (flag) {
				response.sendRedirect("home");
			} else {
				session.setAttribute("changeUserErrMsg", "修改失败，请重试");
				response.sendRedirect("ChangeUserErr");
			}
		} else {
			response.sendRedirect("login");
		}

	}

}
