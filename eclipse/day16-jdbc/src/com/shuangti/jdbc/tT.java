package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tT {
	public static void main(String[] args) {
		Connection connection = JdbcUtils.getConnection();
		try {
			PreparedStatement pps=connection.prepareStatement("select * from USERINFO");
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				System.out.println0(resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
