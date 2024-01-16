package com.shuangti.obj;

public class Person {
	private int age;
	private String name;
	
	
	//set get
	//set 设定
	//get 获取
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age>0&&age<100) {
			this.age = age;
		}else {
			System.out.println("年龄不合格");
		}
		
	}
}
