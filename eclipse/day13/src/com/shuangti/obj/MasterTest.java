package com.shuangti.obj;

public class MasterTest {
	public static void main(String[] args) {
		Master ming = new Master();
		ming.name="明";
		Pet haShiQi= new Cat();
		haShiQi.name="奥利给";
		ming.feed(haShiQi);
	}
}
