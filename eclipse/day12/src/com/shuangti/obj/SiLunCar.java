package com.shuangti.obj;

public class SiLunCar extends CarCar {
	public SiLunCar() {
		this.lunZi_num = 4;
	}

	public void run() {
		System.out.println("开始用" + this.lunZi_num + "个轮子跑");
	}
}
