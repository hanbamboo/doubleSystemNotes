package com.shuangti.test01;

public class Example02 {
	public <H> void test(H h) {
//		test方法在定义的时候不确定形参的类型，这个时候就可以在方法上面加一个泛型
		System.out.println("============" + h);
	};
}
