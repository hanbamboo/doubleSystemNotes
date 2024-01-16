package com.shuangti.basic;

public class Test03 {
	public static void main(String[] args) {
		int x = 0;
		// if第一种用法
		if (x != 1) {
			System.out.println(x);
		}
		// if第二种用法
		int age = 20;
		if (age > 18) {
			System.out.println("成年");
		} else {
			System.out.println("未成年");
		}
		// if第三种用法
		int scroe = 100;
		if (scroe > 90) {
			System.out.println("优");
		} else if (scroe > 70) {
			System.out.println("良");
		} else {
			System.out.println("不及格");
		}
	}
}
