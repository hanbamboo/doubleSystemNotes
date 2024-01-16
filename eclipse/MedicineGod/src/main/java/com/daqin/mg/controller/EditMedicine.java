package com.daqin.mg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daqin.mg.entity.Medicine;
import com.daqin.mg.service.MedicineService;

@WebServlet("/editMedicine")
public class EditMedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyid = request.getParameter("keyid");
		MedicineService medicineService = new MedicineService();
		Medicine medicine = medicineService.queryMedicine(keyid);
		HttpSession session = request.getSession();
		session.setAttribute("SingleMedicine", medicine);
		response.sendRedirect("editMedicine.jsp");
	}

}
