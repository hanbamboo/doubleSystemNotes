package com.shuangti.dog;

import java.util.Iterator;
import java.util.Scanner;

import com.sun.swing.internal.plaf.basic.resources.basic;

/*
 * 通过对象数组，存用户信息
 * 比如一个登录功能，先注册，也就是往数组中存一个对象
 * 在数组当中查找已经注册的对象
 * 		如果存在打印登录成功
 * 		不存在打印登陆失败
 */
public class UserSystem {
	
	static User[] users = new User[100];
	
	static Scanner scanner = new Scanner(System.in);
	static int userCount = 0;
	static boolean login = false;

	public static void main(String[] args) {
		initUser();
		start();
		while (login) {
			list1();
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				showAllUser();
				break;
			case 2:
				login = false;
				start();
				break;
			case 3:

				break;
			default:
				break;
			}
		}
		

	}

	public static void start() {
		while (!login) {
			list0();
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				showAllUser();
				break;
			default:
				break;
			}
		}
	}

	public static void initUser() {
		for (int i = 0; i < users.length; i++) {
			users[i] = new User();
		}
	}

	public static void showAllUser() {
		for (User user : users) {
			if (user.userName == null) {
				break;
			}
			System.out.println(user.id + "\t" + user.userName + "\t" + user.userPwd + "\n");
		}
	}

	public static void list0() {

		System.out.println("===========");
		System.out.println("=  1.登录       =");
		System.out.println("=  2.注册       =");
		System.out.println("= 3.查看成员  =");
		System.out.println("===========");
		System.out.print(" 输入序号操作 ：");
	}

	public static void list1() {

		System.out.println("===========");
		System.out.println("= 1.查看信息  =");
		System.out.println("= 2.退出登录  =");
		System.out.println("===========");
		System.out.print(" 输入序号操作 ：");
	}

	public static void login() {
		System.out.print("请输入用户名：");
		String userName = scanner.next();
		System.out.print("请输入密码：");
		String userPwd = scanner.next();

		int count = 0;
		for (int i = 0; i < users.length; i++) {
			if (users[i].userName != null) {
				if (users[i].userName.equals(userName)) {
					if (users[i].userPwd.equals(userPwd)) {
						System.out.println("登陆成功");
						login = true;
						break;
					} else {
						System.out.println("密码错误");
					}
				} else {
					count++;
				}
				
			} else {
				break;
			}
			

		}
		
	}

	public static void register() {
		System.out.print("请输入用户名：");
		String userName = scanner.next();
		System.out.print("请输入密码：");
		String userPwd = scanner.next();
		users[userCount].id = userCount;
		users[userCount].userName = userName;
		users[userCount].userPwd = userPwd;
		userCount++;
		System.out.println("注册登录成功");
		login = true;
	}
}
