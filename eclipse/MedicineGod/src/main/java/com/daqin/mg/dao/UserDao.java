package com.daqin.mg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.daqin.mg.entity.User;
import com.daqin.mg.util.JdbcUtils;

public class UserDao {
	public boolean saveUser(User user) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		try {
			pps = connection.prepareStatement("insert USERINFO (lname,sname,pwd,phone,mail,rgtime)values(?,?,?,?,?,?)");
			pps.setString(1, user.getLname());
			pps.setString(2, user.getSname());
			pps.setString(3, user.getPwd());
			pps.setString(4, user.getPhone());
			pps.setString(5, user.getMail());
			Date datenow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			pps.setString(6, ft.format(datenow));

			return pps.executeUpdate() >= 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;

	}

	public User checkUser(String lname, String pwd) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			pps = connection.prepareStatement(
					"select * from USERINFO where (lname = ? and pwd = ?) or (mail = ? and pwd = ?) or (phone = ? and pwd = ?)");
			pps.setString(1, lname);
			pps.setString(2, pwd);
			pps.setString(3, lname);
			pps.setString(4, pwd);
			pps.setString(5, lname);
			pps.setString(6, pwd);
			resultSet = pps.executeQuery();
			User user = new User();
			while (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setLname(resultSet.getString(2));
				user.setSname(resultSet.getString(3));
				user.setPwd(resultSet.getString(4));
				user.setPhone(resultSet.getString(7));
				user.setMail(resultSet.getString(8));
				user.setRgTime(resultSet.getString(9));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;

	}

	public boolean changeUser(User user) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		try {
			pps = connection.prepareStatement("update userinfo set sname=?,pwd=?,phone=?,mail=? where lname = ?");
			pps.setString(1, user.getSname());
			pps.setString(2, user.getPwd());
			pps.setString(3, user.getPhone());
			pps.setString(4, user.getMail());
			pps.setString(5, user.getLname());
			return pps.executeUpdate() >= 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;

	}

	public boolean userHas(String lname) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		try {
			pps = connection.prepareStatement("select lname from userinfo where lname = ?");
			pps.setString(1, lname);
			return pps.executeQuery().next();
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
