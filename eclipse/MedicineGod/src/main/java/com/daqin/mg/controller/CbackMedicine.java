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

@WebServlet("/cbackMedicine")
public class CbackMedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String keyid = request.getParameter("keyid");
		MedicineService medicineService = new MedicineService();
		boolean status = medicineService.cbackMedicine(keyid);
		if (status) {
			response.sendRedirect("recycle");
		} else {

		}

	}

}
