package com.shuangti.obj;

public class SecretaryTest {
	public static void main(String[] args) {
		Car bmw = new Car("宝马", "100");
		Secretary secretary = new Secretary("王秘书");
		Car three = new Car("三轮子", "10");
		Car kache = new KaCar("大卡", "11");
		
		secretary.callCar(kache);
	}
}
