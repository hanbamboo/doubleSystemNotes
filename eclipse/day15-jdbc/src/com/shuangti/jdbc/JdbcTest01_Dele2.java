package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01_Dele2 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_04?characterEncoding=utf-8", "root", "123456");
			statement = connection.createStatement();
			statement.executeUpdate("delete from department where dep_id = 2;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
