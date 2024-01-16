package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLoginIn2 {
	public static void main(String[] args) {
		System.out.println("----用户登录----");
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入账号：");
		String name = scanner.next();
		System.out.print("请输入密码：");
		String pwd = scanner.next();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/data_04?characterEncoding=utf-8";
			String uNname = "root";
			String uPwd = "123456";
			String sql = "select * from user where uname = ? and pwd = ? ;";
			connection = DriverManager.getConnection(url, uNname, uPwd);
			statement = connection.prepareStatement(sql);
			//1代表第一个问号,用name的值替换掉第一个问号
			statement.setString(1, name);
			//用pwd的值替换掉第二个问号
			statement.setString(2, pwd);
			resultSet = statement.executeQuery();
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