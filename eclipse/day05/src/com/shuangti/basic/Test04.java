package com.shuangti.basic;

public class Test04 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = a;
		a[1]=10;
		System.out.println(b[1]);
	}
}
