package com.shuangti.basic;

import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.DADD;

public class Test02 {
	public static void main(String[] args) {
		int res1 = sum(10, 20);
		System.out.println(res1);
		print(10, 21111100);
		System.out.println(max(5, 6));
	}

	/*
	 * 求和 返回int
	 */
	public static int sum(int a, int b) {
		return a + b;
	}

	/*
	 * 打印a*b void不返回
	 */
	public static void name() {
	}

	public static void print(int a, int b) {
		System.out.println(a * b);
	}

	/*
	 * 比大小，输出最大值
	 */
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	/*
	 * 1-10找7
	 */
	public static int getSeven() {
		for (int i = 1; i <= 10; i++) {
			if (i == 7) {
				return i;
			}
		}
		return -1;
	}
}
