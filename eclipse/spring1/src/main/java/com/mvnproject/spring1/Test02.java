package com.mvnproject.spring1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext bf = new ClassPathXmlApplicationContext("beans.xml");
		// getBean对应的是xml当中的值
//		User user1 = (User) bf.getBean("user");

		// 获取了类对应的信息，根据此信息就可以获取一个此类对应的实例
		// 这种实现方式就是反射
//		Class clazz = Class.forName("com.mvnproject.spring1.User");
//		User user = (User) clazz.newInstance();

//		System.out.println(user1 + "-" + user);
		// IOC是通过工厂模式和反射模式来实现的。
	}
}
