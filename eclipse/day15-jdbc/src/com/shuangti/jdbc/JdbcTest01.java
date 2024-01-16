package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {
	public static void main(String[] args) {
		
		/*
		 * JDBC连接数据库操作步骤： 
		 * 1.装载驱动 
		 * 2.获得连接 
		 * 3.操作数据(准备sql、编译执行sql、获得结果) 
		 * 4.释放资源
		 */
		Connection connection = null;
		Statement statement =null;
		try {
//			装载mysql的驱动，名字一定要写对，不对就报异常ClassNotFoundException
			Class.forName("com.mysql.cj.jdbc.Driver");
//			DriverManager是驱动管理  getConnection是获得连接的意思
//			URL需要以下几个部分组成
//			1，协议 jdbc:mysql:// 类似于浏览器请求协议https
//			2.ip是服务器唯一标识 localhost -> 127.0.0.1 -> 本地ip
//			3.端口3306，每个进程独占一个
//			4.数据库名data_04
//			账号 root
//			密码 123456
//			jdbc:mysql://localhost:3306/data_04 是完整的链接数据库
//			getConnection 获得连接
			connection =  DriverManager.getConnection("jdbc:mysql://10.10.62.143:3306/shuangti_02?characterEncoding=utf-8","pyb-local","123456");
//			操作数据
//			准备sql
//			sql中对应的表要是url中 的数据库表名对应表名
			String sql = "insert into student values(66,'')";
			statement = connection.createStatement();
//			Update 是更新的意思，可以执行DML语句(DML语句：update、 delete、 insert);
			
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//释放资源，倒序释放
			if (statement!=null) {//可能空指针
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
