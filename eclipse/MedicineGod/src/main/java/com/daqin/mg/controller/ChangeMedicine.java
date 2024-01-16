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

@WebServlet("/changeMedicine")
public class ChangeMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		req.setAttribute("EditMedicineErr", "");
		Medicine medicine = (Medicine) session.getAttribute("SingleMedicine");
		String keyid = req.getParameter("m_keyid");
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
		System.out.println(m_u1_1);
		String m_company = req.getParameter("m_company");
		String m_show_text = req.getParameter("m_showflag");
		int m_show = m_show_text == null ? 0 : 1;
		String muse = m_u1 + "-" + m_u1_1 + "-" + m_u2 + "-" + m_u2_1 + "-" + m_u3 + "-" + m_u3_1;
		medicine.setName(m_name);
		medicine.setDesp(m_desp);
		medicine.setOutdate(m_outdate);
		medicine.setOtc(m_otc);
		medicine.setBarcode(m_barcode);
		medicine.setYu(m_yu);
		medicine.setElabel(m_elabel);
		medicine.setCompany(m_company);
		medicine.setMuse(muse);
		medicine.setKeyid(keyid);
		medicine.setShowflag(m_show);
		MedicineService medicineService = new MedicineService();
		boolean status = medicineService.changeMedicine(medicine);
		if (status) {
			resp.sendRedirect("myMedicine");
		} else {
			req.setAttribute("EditMedicineErr", "修改失败，请重试");
			req.getRequestDispatcher("editMedicine.jsp").forward(req, resp);
		}
	}

}
