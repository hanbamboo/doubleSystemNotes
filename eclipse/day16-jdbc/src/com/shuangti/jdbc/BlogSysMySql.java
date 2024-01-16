package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.shuangti.jdbc.JdbcUtils;

public class BlogSysMySql {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入注册账号：");
		String name_r = scanner.nextLine();
		System.out.print("请输入注册密码：");
		String pwd_r = scanner.nextLine();
//		使用jdbc插入数据
//		调用注册方法
		boolean reg = register(name_r, pwd_r);
		if (reg) {
			if (loginIn(name_r, pwd_r)) {
				System.out.println("登陆成功");
			} else {
				System.out.println("登陆失败");
			}
		}

	}

	public static boolean register(String name, String pwd) {
		Connection con = JdbcUtils.getConnection();
		try {
			// ? 可以叫做占位符
			PreparedStatement ps = con.prepareStatement("select uname from user where uname = ?;");
			ps.setString(1, name);
			ResultSet res = ps.executeQuery();

			if (!res.next()) {
				ps = con.prepareStatement("insert into user values(?,?);");
				ps.setString(1, name);
				ps.setString(2, pwd);
				// executeUpdate() 括号里不需要加sql语句了，因为是预编译
				int status = ps.executeUpdate();
				if (status > 0) {
					System.out.println("####注册成功");
					return true;
				} else {
					System.out.println("####注册失败");
					return false;
				}
			} else {
				System.out.println("####账号已存在，注册失败");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean loginIn(String name, String pwd) {
		Connection con = JdbcUtils.getConnection();
		try {
			// ? 可以叫做占位符
			PreparedStatement ps = con.prepareStatement("select * from user where uname = ? and pwd = ?;");
			ps.setString(1, name);
			ps.setString(2, pwd);
			// executeUpdate() 括号里不需要加sql语句了，因为是预编译
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("uname").equals(name) && resultSet.getString("pwd").equals(pwd)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
