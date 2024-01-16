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

@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("u_name");
		String upwd = request.getParameter("u_pwd");

		/*
		 * 调用UserServices的getuser(name,pwd) getuser(user)调用userDao的queryUser方法
		 * queryUser查询数据库返回登录对象
		 * 
		 */
		UserSerivce userSerivce = new UserSerivce();
		User user = userSerivce.getuser(uname, upwd);
		// 根据返回的User对象是否为空，判断用户是否存在
		// 此对象中保存用户登陆时输入的信息
		// 此user是查询数据库返回的具体对象
		if (user != null) {
			// 如果user不为空则不存在，跳转至首页，否则停留在当前页
			// 浏览器打开发起请求就会建立一个会话对象
			// 此session对象在当前会话共享数据
			//setAttribute("key",value);
			//key 和 value 是一对，取值通过key名字去取
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("home");
		} else {
			response.sendRedirect("login");
		}

	}

}
