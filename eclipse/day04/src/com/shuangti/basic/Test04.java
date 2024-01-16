package com.shuangti.basic;

public class Test04 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 256; i <= 1688; i++) {
			if (i % 13 == 0) {
				System.out.println(i);
				count++;
			}
			if (count == 2) {
				i = 1689;
//				break;
			}
			
		}
	}
}
