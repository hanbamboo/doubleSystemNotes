package com.shuangti.basic;

/*
 * 方法中定义变量（局部变量）必须要给初始值
 */
public class Test04 {
	public static void main(String[] args) {
		print();
	}

	public static void print() {
		int a = 1;
		System.out.println(a);
		// b没有初始值，程序报错
//		int b ;
//		System.out.println(b);
	}
}
