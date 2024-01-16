package com.shuangti.basic;

import java.util.Scanner;

/*
 * 通过main调用普通方法
 * 实现计算器的计算
 */
public class Test06 {
	public static void main(String[] args) {
		int a;
		int b;
		int m;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("第一个数:");
			a = scanner.nextInt();
			System.out.println("第二个数:");
			b = scanner.nextInt();
			System.out.println("===计算器===\n" 
							+ "=  0.退出   = \n"
							+ "=  1.加法   = \n" 
							+ "=  2.减法   = \n" 
							+ "=  3.乘法   = \n"
							+ "=  4.除法   = \n" 
							+ "=========");
			m = scanner.nextInt();
			switch (m) {
			case 0:
				break;
			case 1:
				System.out.println(jia(a, b));
				break;
			case 2:
				System.out.println(jian(a, b));
				break;
			case 3:
				System.out.println(cheng(a, b));
				break;
			case 4:
				System.out.println(chu(a, b));
				break;
			default:
				System.err.println("错误输入");
				break;
			}
		} while (m != 0);

	}

	public static int jia(int a, int b) {
		return a + b;
	}

	public static int jian(int a, int b) {
		return a - b;
	}

	public static int cheng(int a, int b) {
		return a * b;
	}

	public static int chu(int a, int b) {
		return a / b;
	}
}
