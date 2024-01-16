package com.shuangti.basic;

public class Test03 {
	public static void main(String[] args) {
		int a = 10, b = 2;
		a += b;
		System.out.println(a);
		System.out.println(b);
		a -= b;
		System.out.println(a);
		System.out.println(b);
		a *= b;
		System.out.println(a);
		System.out.println(b);
		a /= b;
		System.out.println(a);
		System.out.println(b);
		a %= b;
		System.out.println(a);
		System.out.println(b);
		System.out.println("==========");
		byte c = 126;
		int d = 2;
		c += d;
		//运算的时候可能会出现精度丢失的问题
		//编译器是检查不出来的，所以以后编程需谨慎，多自测
		System.out.println(c);
		System.out.println("==========");
		long f = 100;
		int g = 200;
		f += g;
		System.out.println(f);
		//无论是+=还是-=等赋值运算都会存在自动类型转换

	}
}
