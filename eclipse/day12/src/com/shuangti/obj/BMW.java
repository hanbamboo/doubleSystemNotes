package com.shuangti.obj;

public class BMW extends Car{

	public BMW() {
		super();//不加系统会隐式调用父类的无参构造
		//super()是显示的调用
		System.out.println("子类构造方法");

	}
	
	//构造方法不能被重写，因为子类对象不能创建父类对象
//	public Car() {
//		System.out.println("子类构造方法");
//	}
	
}
