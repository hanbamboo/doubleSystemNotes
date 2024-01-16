package wcom.shuangti.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 请求域对象request
 * 		每发起一个请求，就会创建一个请求域对象
 * 		当前请求的请求域对象中的数据是共享的，不
 * 		同请求(servlet)之间不能共享request的数据
 *
 */
@WebServlet("/req1")
public class Requset1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//往请求域对象当中存一个值
		request.setAttribute("request", "okkk");
	}

	

}
