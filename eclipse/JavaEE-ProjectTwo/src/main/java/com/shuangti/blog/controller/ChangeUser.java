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

@WebServlet("/changeUser")
public class ChangeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String u_name = request.getParameter("u_name");
		String u_pwd = request.getParameter("u_pwd");
		String u_phone = request.getParameter("u_phone");
		String u_email = request.getParameter("u_mail");
		
		User user = (User) session.getAttribute("user");
		user.setName(u_name);
		user.setPwd(u_pwd);
		user.setPhone(u_phone);
		user.setEmai(u_email);
		UserSerivce userSerivce = new UserSerivce();
		boolean status = userSerivce.changeUser(user);
		// 用户中心提交更改表单接受请求
		if(status) {
//			session.removeAttribute("user");
//			session.invalidate();
			session.setAttribute("user", user);
			response.sendRedirect("home");
		}else {
			response.sendRedirect("aboutMe");
		}
	}

}
