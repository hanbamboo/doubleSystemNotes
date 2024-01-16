package com.mvnproject.spring1;

import java.util.Map;
import java.util.Set;

public class Student {
	private String name;
	private int age;
	private User user;
	private String[] hobby;
	private Set<String> ad;
	private Map<String, String> discible;

	public Student() {

	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public Set<String> getAd() {
		return ad;
	}

	public void setAd(Set<String> ad) {
		this.ad = ad;
	}

	public Map<String, String> getDiscible() {
		return discible;
	}

	public void setDiscible(Map<String, String> discible) {
		this.discible = discible;
	}

	public Student(String name, int age, User user, String[] hobby, Set<String> ad, Map<String, String> discible) {
		super();
		this.name = name;
		this.age = age;
		this.user = user;
		this.hobby = hobby;
		this.ad = ad;
		this.discible = discible;
	}

}
