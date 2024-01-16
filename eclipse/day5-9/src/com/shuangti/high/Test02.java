package com.shuangti.high;

import com.shuangti.high.OuterClass.InnerClass2;

public class Test02 {
	public static void main(String[] args) {
		// 实例内部类的方法
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass1 class1 = outerClass.new InnerClass1();
		class1.m1();
		// 静态内部类的方法
		OuterClass.InnerClass2 innerClass2 = new InnerClass2();
		innerClass2.m2();
		// 局部内部类的方法
		outerClass.method1();
		UnNmaeImpl unNmaeImpl = new UnNmaeImpl();
		unNmaeImpl.test();

		// 匿名内部类的方法
		new UnName() {
			public void test() {
				System.out.println("匿名内部类");
			}
		}.test();
		
	}

}
