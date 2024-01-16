package com.shuangti.dqnote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NoteSys2MySql2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//127.0.0.1
			//localhost
			String url = "jdbc:mysql://localhost:3306/d1ata_04?characterEncoding=utf-8";
			String uname = "root";
			String upwd = "123456";
			
			Connection connection = DriverManager.getConnection(url, uname, upwd);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
