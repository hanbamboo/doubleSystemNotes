package com.shuangti.basic;

public class Test02 {
	public static void main(String[] args) {
		int a = 30;
		int b = 30;
		a = (b == 20 ? 2000 : 3000);
		System.out.println(a);
		a = (int) (b == 20 ? 2000 : 11.2);
		System.out.println(a);
	}
}
