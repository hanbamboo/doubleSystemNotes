package com.daqin.mg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daqin.mg.entity.CountMedicine;
import com.daqin.mg.entity.Medicine;
import com.daqin.mg.entity.User;
import com.daqin.mg.service.MedicineService;
import com.daqin.mg.util.Utils;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MedicineService medicineService = new MedicineService();
		if (session.getAttribute("user") != null) {
			ArrayList<Medicine> medicines = medicineService
					.checkMedicine(((User) session.getAttribute("user")).getId());
			CountMedicine countMedicine = new CountMedicine();
			countMedicine.setCount(medicines.size());
			String today_text = Utils.getTimeString();
			long today = Utils.getDateFromString(today_text) / 86400000;
			for (Medicine medicine : medicines) {
				long date = Utils.getDateFromString(medicine.getOutdate()) / 86400000;
				medicine.setOutdate_str(Utils.getOutDateString(date, 2));
				
				if (date <= today) {
					countMedicine.setOut(countMedicine.getOut() + 1);
				} else if (date <= today + 60) {
					countMedicine.setNear(countMedicine.getNear() + 1);
				} else {
					countMedicine.setOk(countMedicine.getOk() + 1);
				}
				String otc = medicine.getOtc();
				switch (otc) {
				case "OTC-R":
					countMedicine.setOtcr(countMedicine.getOtcr() + 1);
					break;
				case "OTC-G":
					countMedicine.setOtcg(countMedicine.getOtcg() + 1);
					break;
				case "NONE":
					countMedicine.setNone(countMedicine.getNone() + 1);
					break;
				case "RX":
					countMedicine.setRx(countMedicine.getRx() + 1);
					break;
				}

			}
			session.setAttribute("countMedicine", countMedicine);
			ArrayList<Medicine> medicinesOpen = medicineService.queryOpenMedicine();
			session.setAttribute("medicinesOpen", medicinesOpen);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
