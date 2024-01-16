package com.shuangti.obj;

public class Secretary {
	public String name;

	public Secretary(String name) {
		this.name = name;
	}

	public void callCar(Car car) {
		
		System.out.println(this.name + "叫了一辆" + car.name);

		car.run();
	}

}
