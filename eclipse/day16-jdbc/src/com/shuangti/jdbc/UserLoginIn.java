package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLoginIn {
	public static void main(String[] args) {
		System.out.println("----用户登录----");
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入账号：");
		String name = scanner.next();
		System.out.print("请输入密码：");
		String pwd = scanner.next();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/data_04?characterEncoding=utf-8";
			String uNname = "root";
			String uPwd = "123456";
			connection = DriverManager.getConnection(url, uNname, uPwd);
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select * from user where uname = '" + name + "' and pwd = '" + pwd + "';");
			// executeQuery 语句只能运行 DQL 语句
			while (resultSet.next()) {
				System.out.println("登录成功");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放顺序：resultSet -> statement -> connection
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
