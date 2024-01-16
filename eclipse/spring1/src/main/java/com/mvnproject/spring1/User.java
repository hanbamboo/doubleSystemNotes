package com.mvnproject.spring1;

public class User {
	public User() {
		System.out.println("调用了构造方法");
	}
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
