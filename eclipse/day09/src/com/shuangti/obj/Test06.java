package com.shuangti.obj;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Computer c = new Computer();
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("第一个数：");
			int a = s.nextInt();
			System.out.print("第二个数：");
			int b = s.nextInt();
			System.out.println("1.加法\t2.减法\n3.乘法\t4.除法\n5.退出\t请输入：");
			int x = s.nextInt();
			if (x == 5) {
				break;
			}
			switch (x) {
			case 1:
				c.jia(a, b);
				break;
			case 2:
				c.jian(a, b);
				break;
			case 3:
				c.cheng(a, b);
				break;
			case 4:
				c.chu(a, b);
				break;
			default:
				System.out.println("数值错误");
				break;
			}
			System.out.println("===========");

		}

	}
}
