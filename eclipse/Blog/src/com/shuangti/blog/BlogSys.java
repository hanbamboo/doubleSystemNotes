package com.shuangti.blog;

import java.util.Scanner;

public class BlogSys {
	static User[] userData = new User[1000];
	static Blog[] blogData = new Blog[1000];
	static Scanner scanner = new Scanner(System.in);
	static int userNum = 0;
	static int blogNum = 0;
	static User localuser = null;

	public static void main(String[] args) {
		while (true) {
			System.out.println("# # # # # #博客系统 # # # # # #");
			System.out.println("#                         #");
			System.out.println("# 1.登录  2.注册  3.所有文章  4.退出    #");
			System.out.println("#                         #");
			System.out.println("# # # # # #博客系统 # # # # # #");
			System.out.print("请选择:");
			int choose = scanner.nextInt();
			if (choose == 1 || choose == 2) {
				System.out.print("请输入用户名：");
				String name = scanner.next();
				System.out.print("请输入密码：");
				int pwd = scanner.nextInt();
				if (choose == 2) { // 注册
					register(name, pwd);
				} else { // 登录
					loginIn(name, pwd);
				}

			}
			if (choose == 3) {
				showAllBlog();
			}
			if (choose == 4) {
				System.exit(0);

			}
		}

	}

	public static void showAllBlog() {
		System.out.println();
		System.out.println("######## 所有文章 #########");
		System.out.println("userId\tblogId\ttitle\tcontent");
		for (int i = 0; i < blogData.length; i++) {
			if (blogData[i] != null) {
				System.out.println(blogData[i].userId + "\t" + blogData[i].blogId + "\t《" + blogData[i].title + "》\t"
						+ blogData[i].content);
			}
		}
		System.out.println("########################");
		System.out.println();

	}

	public static void register(String name, int pwd) {
		User user = new User();
		user.name = name;
		user.pwd = pwd;
		user.id = userNum;
		userData[userNum] = user;
		userNum++;
		System.out.println("###注册成功###");
	}

	public static void loginIn(String name, int pwd) {
		boolean loginSuccess = false;
		for (int i = 0; i < userNum; i++) {
			if (userData[i] != null && userData[i].name.equals(name) && userData[i].pwd == pwd) {
				loginSuccess = true;
				localuser = userData[i];

				while (true) {
					System.out.println("##欢迎您," + name + "##");
					System.out.println("# 1.查看博客 2.发布博客 3.退出#");
					System.out.print("请选择：");
					int choose = scanner.nextInt();
					if (choose == 1) {
						showBlog();
						// TODO:查看
					}
					if (choose == 2) {
						writeBlog();
						// 发布
					}
					if (choose == 3) {
//						System.exit(0);
						localuser = null;
						return;
					}
				}

			}
		}
		if (!loginSuccess) {
			System.out.println("##登陆失败，用户名或密码错误##");
		}
	}

	public static void showBlog() {
		System.out.println("#####################");
		System.out.println("id\t标题\t内容");
		for (int i = 0; i < blogNum; i++) {
			if (blogData[i] != null && blogData[i].userId == localuser.id) {
				System.out.println(blogData[i].blogId + "\t《" + blogData[i].title + "》\t" + blogData[i].content);
			}
		}
		System.out.println("#####################");
		System.out.println();
	}

	public static void writeBlog() {
		System.out.print("请输入标题：");
		String title = scanner.next();
		System.out.print("请输入内容：");
		String content = scanner.next();
		Blog blog = new Blog();
		blog.blogId = blogNum;
		blog.title = title;
		blog.content = content;
		blog.userId = localuser.id;
		blogData[blogNum] = blog;
		blogNum++;
		System.out.println("###博客《" + title + "》已发布###");
	}
}
