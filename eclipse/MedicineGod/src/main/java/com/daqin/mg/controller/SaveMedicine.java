package com.daqin.mg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daqin.mg.entity.Medicine;
import com.daqin.mg.entity.User;
import com.daqin.mg.service.MedicineService;
import com.daqin.mg.util.Utils;

@WebServlet("/saveMedicine")
public class SaveMedicine extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyid = Utils.getRandomKeyId();
		MedicineService medicineService = new MedicineService();
		while (medicineService.checkMedicineKeyid(keyid)) {
			keyid = Utils.getRandomKeyId();
		}
		req.setCharacterEncoding("utf-8");
		String m_name = req.getParameter("m_name");
		String m_desp = req.getParameter("m_desp");
		String m_outdate = req.getParameter("m_outdate");
		String m_otc = req.getParameter("m_otc");
		String m_barcode = req.getParameter("m_barcode");
		int m_yu = Integer.parseInt(req.getParameter("m_yu"));
		int m_uid = Integer.parseInt(req.getParameter("m_uid"));
		String m_elabel = req.getParameter("m_elabel").replace(" ", "@@");
		String m_u1 = req.getParameter("m_u1");
		String m_u2 = req.getParameter("m_u2");
		String m_u3 = req.getParameter("m_u3");
		String m_u1_1 = req.getParameter("m_u1_1");
		String m_u2_1 = req.getParameter("m_u2_1");
		String m_u3_1 = req.getParameter("m_u3_1");
		String m_company = req.getParameter("m_company");
		String m_show_text = req.getParameter("m_showflag");
		int m_show = m_show_text == null ? 0 : 1;
		String muse = m_u1 + "-" + m_u1_1 + "-" + m_u2 + "-" + m_u2_1 + "-" + m_u3 + "-" + m_u3_1;
		Medicine medicine = new Medicine(0, m_uid, keyid, m_name, m_desp, null, m_outdate, m_otc, m_barcode, m_yu,
				m_elabel, muse, 0, null, m_company, 0, m_show);
		boolean status = medicineService.saveMedicine(medicine);
		if (status) {
			resp.sendRedirect("home");
		} else {
			req.setAttribute("SaveMedicineErr", "新增药品失败，请重试");
			req.getRequestDispatcher("addMedicine.jsp").forward(req, resp);
		}
	}

}
