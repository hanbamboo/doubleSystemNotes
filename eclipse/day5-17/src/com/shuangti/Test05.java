package com.shuangti;

public class Test05 {
	public static void main(String[] args) {
		Station staion = new Station();
		Thread t1 = new Thread(staion, "窗口1");
		Thread t2 = new Thread(staion, "窗口2");
		Thread t3 = new Thread(staion, "窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}
