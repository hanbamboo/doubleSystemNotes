package com.mvnproject.spring1;

public class Factory {
	public static UserDao userDao = null;

	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}
}
