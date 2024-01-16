package com.shuangti;

import java.sql.*;

/*
 * JDBC工具类
 * */
public class JdbcUtils {
//	public static final String url = "";
	//静态代码块,类加载的时候只执行一次，以后再也不执行了
	static {
		try {
			//注释
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 获得连接
	 * */
	public static Connection getCon() {
		
		String url = "jdbc:mysql://139.224.48.87:3306/mg?characterEncoding=utf-8&useSSL=false";
		String uName = "mg";
		String pwd = "Qhx010394Mg";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,uName,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	/*
	 * 释放资源
	 * ResultSet
	 * Statement或PrepareStatement
	 * Connection
	 * 释放资源有顺序 ResultSet->Statment或PrepareStatement->Connection
	 * */
	public static void close(Connection con, 
			Statement stat, PreparedStatement pre,ResultSet ret) {
		if(ret != null) {
			try {
				ret.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pre != null) {
			try {
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
