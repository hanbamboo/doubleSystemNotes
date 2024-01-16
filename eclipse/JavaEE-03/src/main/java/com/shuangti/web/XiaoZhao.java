package com.shuangti.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/XiaoZhao")
public class XiaoZhao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String key = (String) request.getAttribute("key");
//		String name = request.getParameter("name");
//		if (key.equals("通过")) {
//			System.out.println(name+"请假通过-xiaohong");
//		}else {
//			System.out.println(name+"请假失败-xiaohong");
//		}
		
		
		
		System.out.println("请假通过-xiaohong");

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
