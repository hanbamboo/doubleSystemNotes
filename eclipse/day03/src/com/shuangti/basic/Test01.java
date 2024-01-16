package com.shuangti.basic;

public class Test01 {
	public static void main(String[] args) {
		int a = 1;
		//&&短路与
		//true && true 为 true
		//true && false 为 false
		//false && true 为 false
		//false && false 为 false
		System.out.println((4>3)&&(5<2));
		System.out.println((4<2)&&(5>a++));
		//短路后后续不进行
		//||短路或
		//true || true 为 true
		//true || false 为true
		//false || true 为true
		//false || false 为 false
		System.out.println((2>1)||(4<5));
		int b =2;
		System.out.println((5>3)||(6<b++));
	
		
		
	}
}
