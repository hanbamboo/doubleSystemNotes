package wcom.shuangti.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/app")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前应用的应用域对象
		ServletContext sc=  this.getServletContext();
		//在域对象当中存了一个值，这个值在当前应用所有用户共享
		/*
		 * ServletContext应用域对象
		 * 某一个web应用所有用户会共享这个对象
		 * 那么对象当中的数据也是所有用户共享的
		 * 		生命周期：
		 * 			应用启动创建，应用停止对象销毁
		 * 
		 * 方法:setAttribute("key", "value");
		 * 		可以往应用域对象中存值
		 * 	    getAttribute("key")
		 * 		可以在应用域对象中取值
		 */
		sc.setAttribute("allUserData", "111");
		//打印当前请求上下文路径(当前项目路径)
		//打印的结果是  =>  /JavaEE-04
		System.out.println(sc.getContextPath());
		

		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
