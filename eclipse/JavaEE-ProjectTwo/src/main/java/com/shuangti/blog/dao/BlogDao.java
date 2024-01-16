package com.shuangti.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.shuangti.blog.entity.Blog;
import com.shuangti.blog.util.JdbcUtils;

public class BlogDao {

	public boolean createBlog(String tilte, String context, int uid, String uname) {
		// 链接数据库，获得数据
		Connection connection = null;
		PreparedStatement pps = null;
		try {
			// 獲得鏈接
			Date date = new Date();
			String strDateFormat = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
			String time = sdf.format(date);
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("INSERT `blog` VALUES(NULL,?,?,?,0,NULL,0,?,?)");
			pps.setString(1, tilte);
			pps.setString(2, context);
			pps.setInt(3, uid);
			pps.setString(4, time);
			pps.setString(5, uname);
			int status = pps.executeUpdate();
			return status >= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}

		return false;
	}

	public ArrayList<Blog> queryMyBlogs(int uid) {
		// 链接数据库，获得数据
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		Connection connection = null;
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("select * from `blog` where uid = ? and del_flag=0");
			pps.setInt(1, uid);
			resultSet = pps.executeQuery();
			while (resultSet.next()) {
				Blog blog = new Blog();
				blog.setId(resultSet.getInt(1));
				blog.setTitle(resultSet.getString(2));
				blog.setContext(resultSet.getString(3));
				blog.setUid(resultSet.getInt(4));
				blog.setZan(resultSet.getInt(5));
				blog.setPinglun(resultSet.getString(6) == null ? "无" : resultSet.getString(6));
				blog.setDelflag(resultSet.getInt(7));
				blog.setTime(resultSet.getString(8));
				blog.setUname(resultSet.getString(9));
				blogs.add(blog);
			}
			return blogs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public ArrayList<Blog> queryAllBlogs() {
		// 链接数据库，获得数据
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		Connection connection = null;
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("select * from `blog` where del_flag = 0");
			resultSet = pps.executeQuery();
			while (resultSet.next()) {
				Blog blog = new Blog();
				blog.setId(resultSet.getInt(1));
				blog.setTitle(resultSet.getString(2));
				blog.setContext(resultSet.getString(3));
				blog.setUid(resultSet.getInt(4));
				blog.setZan(resultSet.getInt(5));
				blog.setPinglun(resultSet.getString(6) == null ? "无" : resultSet.getString(6));
				blog.setDelflag(resultSet.getInt(7));
				blog.setTime(resultSet.getString(8));
				blog.setUname(resultSet.getString(9));
				blogs.add(blog);
			}
			return blogs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public boolean delBlog(int id) {
		// 链接数据库，获得数据
		Connection connection = null;
		PreparedStatement pps = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("update `blog` set del_flag = 1 where id = ?");
			pps.setInt(1, id);
			int status = pps.executeUpdate();
			return status >= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public Blog getBlog(int id) {
		// 链接数据库，获得数据
		ArrayList<Blog> blogs = new ArrayList<Blog>();
		Connection connection = null;
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("select * from `blog` where id = ? and del_flag = 0");
			pps.setInt(1, id);
			resultSet = pps.executeQuery();

			while (resultSet.next()) {
				Blog blog = new Blog();
				blog.setId(resultSet.getInt(1));
				blog.setTitle(resultSet.getString(2));
				blog.setContext(resultSet.getString(3));
				blog.setUid(resultSet.getInt(4));
				blog.setZan(resultSet.getInt(5));
				blog.setPinglun(resultSet.getString(6) == null ? "无" : resultSet.getString(6));
				blog.setDelflag(resultSet.getInt(7));
				blog.setTime(resultSet.getString(8));
				blog.setUname(resultSet.getString(9));
				blogs.add(blog);
				return blog;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public boolean changeBlog(int blogId, String title, String context) {
		// 链接数据库，获得数据
		Connection connection = null;
		PreparedStatement pps = null;
		try {
			// 獲得鏈接
			connection = JdbcUtils.getCon();
			pps = connection.prepareStatement("update `blog` set title = ?,context = ? where id = ? and del_flag = 0");
			pps.setString(1, title);
			pps.setString(2, context);
			pps.setInt(3, blogId);
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
