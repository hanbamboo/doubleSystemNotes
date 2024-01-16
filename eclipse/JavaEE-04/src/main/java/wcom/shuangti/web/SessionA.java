package wcom.shuangti.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 会话域对象Session
 * 什么是会话？
 * 		简单的理解为每一个浏览器打开关闭的一个过程就是一个会话
 * Session机制？
 * 		浏览器打开发起第一次session请求，到了servlet层，他会先
 * 		检查当前sessionId是否存在，如果不存在则会创建一个session
 * 		对象并生成一个唯一ID
 * 		当前浏览器未关闭时，重新发起另一个请求时，会将浏览器中的
 * 		cookie当中存放的上次生成的sessionId带过来，这个时候
 * 		servletId已存在，则不会重新创建session对象，然后会根据
 * 		当前sessionId找到对应的session对象然后实现会话数据共享。
 * 说明：	
 * 		1.一个会话的前提肯定是一个同浏览器
 * 		2.会话可以清除，比如手动清除cookie的数据或关闭浏览器会话结束
 * 		3.默认30分钟后更换，也可使用setMaxInactiveInterval()设置会话有效期
 */
@WebServlet("/sa")
public class SessionA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getSession()获取当前请求的会话域对象
		//每一个会话都会共享这个对象hSession
		HttpSession hSession = request.getSession();
		hSession.setAttribute("Session", "SessionA");
		System.out.println("SessionID="+hSession.getId());
		hSession.setMaxInactiveInterval(10);

	}

}
