package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	public static final String uRL = "jdbc:mysql://139.224.48.87:3306/mg?characterEncoding=utf-8&useSSL=false";
	public static final String uNname = "mg";
	public static final String uPwd = "Qhx010394Mg";
	// 静态代码块，类加载的时候只执行一次，以后再也不执行了
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获得连接
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(uRL, uNname, uPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/*
	 * 释放资源 ResultSet Connection Statement 或 PrepareStatement 释放循序 ResultSet ->
	 * Statement -> PreparedStatement -> Connection
	 */
	public static void closeConnection(Connection c, Statement s, PreparedStatement pps, ResultSet r) {

		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (r != null) {
			try {
				r.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pps != null) {
			try {
				pps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
