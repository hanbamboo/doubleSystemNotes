package com.shuangti.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.shuangti.blog.entity.Blog;
import com.shuangti.blog.entity.User;
import com.shuangti.blog.util.JdbcUtils;

public class UserDao {
	public boolean insertUser(User user) {
		// 链接数据库，保存数据
		Connection connection = null;
		PreparedStatement pps = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("INSERT `user` VALUES(NULL,?,?,?,?)");
			pps.setString(1, user.getName());
			pps.setString(2, user.getPwd());
			pps.setString(3, user.getPhone());
			pps.setString(4, user.getEmai());
			int status = pps.executeUpdate();
			return status >= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public User queryUser(String name, String pwd) {
		// 链接数据库，获得数据
		Connection connection = null;
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("select * from `user` where u_name = ? and u_pwd = ?");
			pps.setString(1, name);
			pps.setString(2, pwd);

			resultSet = pps.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));

				user.setName(resultSet.getString(2));
				user.setPwd(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setEmai(resultSet.getString(5));
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public boolean changeUser(User user) {
		// 链接数据库，获得数据
		Connection connection = null;
		PreparedStatement pps = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("UPDATE `user` SET u_name=?,u_pwd=?,u_phone=?,u_mail=? WHERE u_id = ?");
			pps.setString(1, user.getName());
			pps.setString(2, user.getPwd());
			pps.setString(3, user.getPhone());
			pps.setString(4, user.getEmai());
			pps.setInt(5, user.getId());
			int status = pps.executeUpdate();
			return status >= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public void closeDB(Connection connection, PreparedStatement pps, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
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
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeDB(Connection connection, PreparedStatement pps) {
		if (connection != null) {
			try {
				connection.close();
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

	public void closeDB(PreparedStatement pps, ResultSet resultSet) {
		if (pps != null) {
			try {
				pps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeDB(Connection connection, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
