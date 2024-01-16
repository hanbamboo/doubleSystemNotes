package com.daqin.mg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daqin.mg.service.MedicineService;

@WebServlet("/delMedicine")
public class DelMedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyid = request.getParameter("keyid");
		MedicineService medicineService = new MedicineService();
		boolean status = medicineService.delMedicine(keyid);
		if (status) {
			response.sendRedirect("myMedicine");
		} else {
			
		}
	}

}
