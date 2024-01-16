package com.shuangti.basic;

public class Test05 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 256; i <= 1688; i++) {
			if (i % 13 == 0) {
				count++;
				if (count==1) {
					continue;
				}
				System.out.println(i);
			}
			
		}
	}
}
