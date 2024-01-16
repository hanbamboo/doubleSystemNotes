package com.shuangti.obj;

public class KaCar extends Car{

	public KaCar(String name, String speed) {
		super(name, speed);
	}

	public void run() {
		// 秘书叫小汽车需要C照司机
		// 秘书叫卡车需要A照司机
		
			System.out.println("需要A照");
		
		System.out.println(this.name + "发动");
		System.out.println(this.name + "以" + this.speed + "km/h的速度赶了过来");
	}
	
}
