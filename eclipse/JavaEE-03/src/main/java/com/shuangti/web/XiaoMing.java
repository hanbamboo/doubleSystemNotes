package com.shuangti.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/XiaoMing")
public class XiaoMing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String name = request.getParameter("name");
//		request.setAttribute("key", "通过");
//		System.out.println(name + "请假通过-xiaoming");
//
//		request.getRequestDispatcher("XiaoZhao").forward(request, response);

		
		System.out.println("请假不通过-xiaoming");
		response.sendRedirect("XiaoZhao");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
