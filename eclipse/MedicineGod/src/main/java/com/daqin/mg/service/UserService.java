package com.daqin.mg.service;

import com.daqin.mg.dao.UserDao;
import com.daqin.mg.entity.User;

public class UserService {

	public boolean saveUser(User user) {

		UserDao userDao = new UserDao();
		return userDao.saveUser(user);

	}

	public User checkUser(String lname, String pwd) {

		UserDao userDao = new UserDao();
		return userDao.checkUser(lname, pwd);

	}

	public boolean changeUser(User user) {

		UserDao userDao = new UserDao();
		return userDao.changeUser(user);

	}

	public boolean userHas(String lname) {

		UserDao userDao = new UserDao();
		return userDao.userHas(lname);

	}
}
