package com.shuangti.basic;

//字符串拼接
//将多个字符串拼接成一个
public class Test02 {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2;// helloworld
		String s4 = s1 + 10;// hello10
		String s5 = s1 + 10 + 20;// hello1020
		String s6 = 10 + 20 + s1;// 30hello
		String s7 = 10 + (20 + s1);// 1020hello
		System.out.println(s7);
	}
}
