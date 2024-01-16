package com.shuangti;

public class Thred1 {
	public static void main(String[] args) {
		Thred11 t11 = new Thred11();
		Thred22 t22 = new Thred22();
		t11.start();
		t22.start();
		System.out.println("---------");
	}

}
