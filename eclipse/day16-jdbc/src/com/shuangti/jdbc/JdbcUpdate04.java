package com.shuangti.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 将张三的密码改为123456
 */
public class JdbcUpdate04 {
	public static void main(String[] args) {
		Connection con = JdbcUtils.getConnection();
		PreparedStatement ps = null;
		//加载驱动，jdbc会z自动加载，会获得连接
		
		//操作数据
		String sql = "update user set pwd= 123456 where uname ='zhangsan'";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
