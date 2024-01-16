package com.mvnproject.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
	public static void main(String[] args) {
//		加载spring配合文件，实例化对象，生成工厂类对象，由此工厂类对象实现统一管理
//		配置文件中的对象
		ApplicationContext bf = new ClassPathXmlApplicationContext("beans.xml");
//		User u1 = (User) bf.getBean("user");
//		User u2 = (User) bf.getBean("user");
		User u3 = (User) bf.getBean("user1");
//		System.out.println(u1);
//		System.out.println(u2);
	}
}
