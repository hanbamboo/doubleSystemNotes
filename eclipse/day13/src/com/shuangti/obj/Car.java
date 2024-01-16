package com.shuangti.obj;

public class Car {
	String name;
	String speed;

	public Car(String name,String speed) {
		this.name = name;
		this.speed = speed;
	}

	public void run() {
		// 秘书叫小汽车需要C照司机
		// 秘书叫卡车需要A照司机
		
		System.out.println(this.name + "发动");
		System.out.println(this.name + "以" + this.speed + "km/h的速度赶了过来");
	}
}
