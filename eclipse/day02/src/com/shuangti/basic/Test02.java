package com.shuangti.basic;

public class Test02 {
	public static void main(String[] args) {
		int a = 10, b = 3;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		System.out.println("=================");
		int c = 1;
		System.out.println(c++);
		System.out.println(++c);
		System.out.println("=================");
		int d = 1;
		int f = d++;
		/*
		 * 第一件事：先把d的值给f
		 * 第二件事：d自增，d本身加1，这时候d=d+1=2
		 * */
		System.out.println(f);
		f = ++d;
		System.out.println(f);

	}
}
