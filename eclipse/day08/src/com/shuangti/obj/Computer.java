package com.shuangti.obj;

import java.util.Arrays;
import java.util.Scanner;


public class Computer {
	public static void main(String[] args) {
		//定义一个差不多长度的数组接收
		int[] a = new int[10];
		Scanner s = new Scanner(System.in);
		System.out.println("输入一个数：");
		int num = s.nextInt();
		int total = num;
		int temp = 0;
		while (true) {
			a[temp] = num % 8;
			temp++;
			num /= 8;
			if (num == 0) {
				break;
			}
		}
//		System.out.println(Arrays.toString(a));
		System.out.print(total + "的八进制是");
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != 0) {
				System.out.print(a[i]);
			}
		}
		System.out.println();
		temp = 0;
		num= total;
		while (true) {
			a[temp] = num % 2;
			temp++;
			num /= 2;
			if (num == 0) {
				break;
			}
		}
		System.out.print(total + "的二进制是");
		for (int i = temp - 1; i >= 0; i--) {
				System.out.print(a[i]);
		}
	}

}
