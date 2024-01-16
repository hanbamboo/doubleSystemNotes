package com.shuangti.basic;

public class Test03 {
	public static void main(String[] args) {
		int i = 1;
		while (i <= 100) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
			i++;
		}
		System.out.println("============");
		int j = 1;
		do {
			if (j % 2 == 0) {
				System.out.println(j);
			}
			;
			j++;
		} while (j <= 100);
	}
}
