package com.daqin.mg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daqin.mg.entity.User;

@WebServlet("/addMedicine")
public class AddMedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("SaveMedicineErr", "");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			request.getRequestDispatcher("addMedicine.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

}
