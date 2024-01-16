package wcom.shuangti.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sb")
public class SessionB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取当前对象
		HttpSession hSession = request.getSession();
		//从当前会话域对象中取值
		String msg = (String) hSession.getAttribute("Session");
		System.out.println(msg);
		System.out.println("SessionID="+hSession.getId());

	}

}
