package com.shuangti.obj;

public class Test01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		// 不加try...catch是由jvm处理的，程序会被中断，不会继续往下运行。
		// 加了try...catch是可以自己手动处理的异常，没有交给jvm处理
		try {
			// 有问题的代码块
			System.out.println(a / b);
		} catch (Exception e) {// catch异常类
			// 异常处理代码块
			// printStackTrace 是自己手动打印的信息
			e.printStackTrace();
			System.out.println("！！！！！！！！！！！！！！！！");
		}
		System.out.println("11");
		aaa(10);


	}
	
	public static void aaa(int i) throws ArrayIndexOutOfBoundsException {
		int[] a = new int[2];
		a[i]=10;
	}
}
