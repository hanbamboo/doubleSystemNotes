package test;

import java.util.Random;

import java.util.Scanner;

public class day0305 {
	public static void main(String[] args) {
//		for (int i = 100; i < 1000; i++) {
//			int a = i%10;
//			int b = i/10%10;
//			int c = i/100;
//			int d = a*a*a+b*b*b+c*c*c;
//			if (i==d) {
//				System.out.println(i);
//			}
//		}
		
//		int a = 100;
//		int sum = 0;
//		while (a<=200) {
//			sum+=a;
//			a++;
//		}
//		System.out.println(sum);
//		
//		for (int b = 100;b<=200; b++) {
//			sum+=b;
//		}
//		System.out.println(sum);
//		
//		do {
//			sum+=a;
//			a++;
//		} while (a<=200);
//		System.out.println(sum);
		
//		
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		if (a % 3 == 0 && a % 5 == 0 && a % 7 == 0) {
//			System.out.println(a);
//		}
		
//		
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		System.out.println(add(8.3, 1.7));
		System.out.println(add(10, 10));
		System.out.println(add(10, 10,30));

	}
	
	
	public static int add(int a,int b) {
		return a+b;
	}
	public static int add(int a,int b,int c) {
		return a+b+c;
	}
	public static double add(double a,double b) {
		return a+b;
	}
}