package com.shuangti.basic;

public class Test02 {
	public static void main(String[] args) {
//		for (int i = 2; i <= 100; i += 2) {
//			System.out.println(i);
//		}
//		System.out.println("=============");
//		for (int i = 1; i <= 100; i++) {
//			if (i % 2 == 0) {
//				System.out.println(i);
//			}
//		}
//		System.out.println("=============");
		int i, j;
		for (i = 2; i <= 100; i++) {

			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					System.err.println(i);
					break;
				}
			}
			if (j >= i) {
				System.out.println(i);
			}
//			if(isSushu(i)) {
//				System.out.println(i);
//			}
		}
	}
	public static boolean isSushu(int num) {
		for (int i = 2; i < num; i++) {
			if (num%i==0) {
				return false;
			}
		}
		return true;
		
	}
}
