package com.shuangti.obj;

public class ErLunCar extends CarCar {
	public ErLunCar() {
		this.lunZi_num = 2;
	}

	public void run() {
		System.out.println("开始用" + this.lunZi_num + "个轮子跑");
	}
}
