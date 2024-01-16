package com.shuangti.obj;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Car car = new Car();
		car.printCar(13);
		Scanner s = new Scanner(System.in);
		while (true) {
			int local = s.nextInt();
			car.go(local);
		}
	}
}
