package com.shuangti.obj;

public class JieCheng {
	public static void main(String[] args) {
		int num, sum = 0;
		for (int i = 1; i <= 10; i++) {
			num = 1;
			for (int j = 1; j <= i; j++) {
				num *= j;
			}
			sum += num;
		}
		System.out.println(sum);
	}
}
