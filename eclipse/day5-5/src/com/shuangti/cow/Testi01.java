package com.shuangti.cow;
/*
 * final关键字
 * 		最终的、不可见的
 * 1.修饰变量 
 * 		基本数据类型
 * 			一旦被赋值，就不能被改变了
 * 		引用数据类型
 * 			引用是一个变量，变量指向的地址，用final修饰的引用：
 * 				他的地址是不可变的，但是引用指向的内存地址的数据是可以改变的
 * 2.修饰方法
 * 		不能被重写
 * 3.修饰类
 * 		不能被继承
 * 
 * 项目用到最多的地方是用来静态变量
 * 		
 */
public class Testi01 {
	public static void main(String[] args) {
		final int a;
		a = 10;
		A a2 = new A();
		a2.test();

	}
}
