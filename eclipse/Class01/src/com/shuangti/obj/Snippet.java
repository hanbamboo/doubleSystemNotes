package com.shuangti.obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Snippet {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 127.0.0.1
			// localhost
			String url = "jdbc:mysql://localhost:3306/data_04?characterEncoding=utf-8";
			String uname = "root";
			String upwd = "123456";

			Connection connection = DriverManager.getConnection(url, uname, upwd);

			String sql = "select * from department";

			PreparedStatement pps = connection.prepareStatement(sql);
			ResultSet res = pps.executeQuery();

//			while (res.next()) {
//				System.out.println(res.getString(2));
//			}
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			String pwd = scanner.next();

			login(name, pwd);

//			
//			String sql2 = "insert into user values(?,?)";
//			PreparedStatement pps2 = connection.prepareStatement(sql2);
//			pps2.setString(1, name);
//			pps2.setString(2, pwd);
//			int a = pps2.executeUpdate();
//			if (a > 0) {
//				System.out.println("插入成功");
//			} else {
//				System.out.println("插入失败");
//			}
////			pps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// 如果返回为true，登录成功
	// 如果false ，登陆失败s
	public static void login(String name, String pwd) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 127.0.0.1
			// localhost
			String url = "jdbc:mysql://localhost:3306/data_04?characterEncoding=utf-8";
			String uname = "root";
			String upwd = "123456";

			Connection connection = DriverManager.getConnection(url, uname, upwd);

			String sql = "SELECT  * FROM `user` WHERE uname = ? AND pwd = ?;";

			PreparedStatement pps = connection.prepareStatement(sql);
			pps.setString(1, name);
			pps.setString(2, pwd);

			ResultSet res = pps.executeQuery();
			if (res.next()) {
				System.out.println("登陆成功");
			}else {
				System.out.println("登陆失败");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
