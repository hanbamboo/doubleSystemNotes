package com.shuangti.obj;

public class Car {
	int step;

	public void printCar(int local) {
		this.step = local;
		for (int i = 0; i < 15; i++) {
			if (local > 0) {
				System.out.print("_");
				if (i == local) {
					System.out.print("🚗");
				}
			} else {
				if (local < 0) {
					local = -local;
				}
				System.out.print("_");
				if (i == local) {
					System.out.print("🚗");

				}
			}
		}
	}

	public void go(int step) {
		this.step = this.step - step;
		printCar(this.step);
	}

//	public void back(int step) {
//		this.step += step;
//		printCar(step);
//	}
}
