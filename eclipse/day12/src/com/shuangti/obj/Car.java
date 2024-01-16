package com.shuangti.obj;

public class Car {
	String name;
	public void run() {
		System.out.println("车会跑");
	}
	
	
	public Car() {
		System.out.println("父类构造方法");
	}


	public Car(String name) {
		this.name = name;
	}
	
}
