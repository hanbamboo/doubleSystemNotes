package com.shuangti.basic;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		if (score > 90) {
			System.out.println("优秀");
		} else if (score > 70) {
			System.out.println("良好");
		} else {
			System.out.println("不合格");
		}
	}
}
