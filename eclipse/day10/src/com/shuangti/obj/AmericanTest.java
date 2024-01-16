package com.shuangti.obj;

public class AmericanTest {
	public static void main(String[] args) {
		American tlp = new American();
		tlp.carId = 1001;
		tlp.nation = "美国";

		American bd = new American();
		bd.carId = 1002;
		bd.nation = "中国";
		
		American abm = new American();
		abm.carId = 1003;
		abm.nation = "美国";
		American.eat();
		//静态变量使用的时候要用    类名.静态变量名    不能用对象
	}
}
