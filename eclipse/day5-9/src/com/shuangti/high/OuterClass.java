package com.shuangti.high;

/*
 * 内部类，定义在普通类当中的类
 * 		隐藏细节、增强封装性
 * 		(了解即可，以后见到别人写的代码知道是个内部类就行)
 * 分类：
 * 		实例内部类
 * 		静态内部类
 * 		局部内部类(定义在方法当中的类)
 * 			只能在当前方法中使用
 * 		匿名内部类
 * 			有些接口的方法想要使用的时候不想单独创建一个java实现方法再实例化去调用，
 * 			这个时候就可以写使用匿名内部类
 * 			new UnName() {
 *				public void test() {
 *					System.out.println("匿名内部类");
 *				}
 *	 		}.test();
 *
 */
public class OuterClass {

	// 属性(成员变量)
	// 实例变量
	// 静态变量
	// 方法
	// 实例方法
	// 静态方法

	// 实例内部类
	public class InnerClass1 {
		int a;

		public void m1() {
			System.out.println("实例内部类的方法");
		}
	}

	// 静态内部类
	public static class InnerClass2 {
		int b;

		public void m2() {
			System.out.println("静态内部类的方法");
		}
	}

	public void method1() {

		// 局部内部类
		class InnerClass3 {
			int c;

			public void m3() {
				System.out.println("局部内部类的方法");
			}
		}
		InnerClass3 innerClass3 = new InnerClass3();
		innerClass3.m3();
	}

}
