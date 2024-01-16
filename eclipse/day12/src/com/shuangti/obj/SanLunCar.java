package com.shuangti.obj;

public class SanLunCar extends CarCar {

	public SanLunCar() {
		this.lunZi_num = 3;
	}

	public void run() {
		System.out.println("开始用" + this.lunZi_num + "个轮子跑");
	}
}
