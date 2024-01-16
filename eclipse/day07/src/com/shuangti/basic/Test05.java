package com.shuangti.basic;

/*
 * 方法相互调用
 * 方法可以调用方法，但是不能嵌套方法，跟if、for不一样
 * 方法在类当中的位置没要求
 * 尽量不要写方法的相互调用、
 * 递归调用
 * 方法调用遵循栈的原则，先进后出
 */
public class Test05 {
	public static void main(String[] args) {
		method3();
	}

	public static void method1() {
		System.out.println("1");
		method2();
	}

	public static void method2() {
		System.out.println("2");
		method1();
	}
	public static void method3() {
		System.out.println(3);
		method3();
	}

}
