package com.shuangti.blog.service;

import java.util.ArrayList;

import com.shuangti.blog.dao.UserDao;
import com.shuangti.blog.entity.Blog;
import com.shuangti.blog.entity.User;

/*
 * Serivce 是 保存数据之前
 * 做一些业务逻辑处理
 */
public class UserSerivce {
	public boolean saveUser(User user) {
		// TODO:通过userDAO的insert方法保存用户
		UserDao ud = new UserDao();
		return ud.insertUser(user);
	}

	public User getuser(String name, String pwd) {

		UserDao ud = new UserDao();
		return ud.queryUser(name, pwd);

	}
	public boolean changeUser(User user) {
		UserDao ud = new UserDao();
		return ud.changeUser(user);
	}
	

}
