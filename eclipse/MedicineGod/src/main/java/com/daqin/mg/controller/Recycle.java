package com.daqin.mg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daqin.mg.entity.Medicine;
import com.daqin.mg.entity.User;
import com.daqin.mg.service.MedicineService;


@WebServlet("/recycle")
public class Recycle extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			MedicineService medicineService = new MedicineService();
			int uid = user.getId();
			ArrayList<Medicine> medicines = medicineService.queryMedicineBeDel(uid);
			session.setAttribute("medicinesBeDel", medicines);
			response.sendRedirect("recycle.jsp");
		} else {
			response.sendRedirect("login");
		}
				
	}

	

}
