package com.shuangti.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection conn = JdbcUtils.getCon();
		try {
			PreparedStatement pps = conn.prepareStatement("select * from user where u_name = ?");
			pps.setString(1, id);
			ResultSet resultSet =  pps.executeQuery();
			
			if (resultSet.next()) {
				request.setAttribute("u_name", resultSet.getString("u_name"));
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			}else {
				request.setAttribute("u_name", id);
				request.getRequestDispatcher("loginError.jsp").forward(request, response);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
