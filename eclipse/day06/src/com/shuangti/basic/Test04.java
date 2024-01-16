package com.shuangti.basic;

public class Test04 {
	public static void main(String[] args) {
		//StringBuffer 线程安全
		//StringBuilder 非线程安全
		StringBuffer s1 = new StringBuffer("hello");
		s1.append("world");
		//+和append区别，+如果是字符串对象的拼接需要每次都创建
		//StringBuffer.append不需要每次都创建
		
		System.out.println(s1);
		System.out.println(s1.reverse());
		StringBuffer s2 =new StringBuffer("123456");
		System.out.println(s2.delete(0, 2));
		
		StringBuilder sb = new StringBuilder("helloworld");
	}
}
