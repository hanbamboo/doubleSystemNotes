package com.shuangti.obj;

public class Test07 {
	public static void main(String[] args) {
		PersonM xiaoMing = new PersonM();
		xiaoMing.name = "小明";
		xiaoMing.weight = 90;
		
		
		System.out.println("小明的减肥前的体重是" + xiaoMing.weight);
		for (int i = 0; i < 10; i++) {
			if (i<3) {
				xiaoMing.basketball();
			}
			xiaoMing.run();
		}
		
		System.out.println("小明的减肥后的体重是" + xiaoMing.weight);
	}
}
