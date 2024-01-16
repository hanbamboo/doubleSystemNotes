package com.shuangti.basic;

//字符串比较
//1.==比较的是字地址
//2.equals比较的是字面值
public class Test03 {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1;
		String s4 = "hello";
		String s5 = new String("hello");
		String s6 = new String("hello");
		String s7 = "helloworld";
		//先创建一个字符串对象，然后将两个字符串值拼接
		//去常量池搜索，如果存在，将对象的地址指向该字符串常量池的地址
		//然后将对象的地址给到s8
		String s8 = s1 + s2;
		//先拼接字符串，然后去常量池搜索拼接后的字符串
		//如果存在直接将该常量池中的字符串地址指向s8
		String s9 = "hello" + "world";
		String s10 = s1 + "world";
		String s11 = "hello" + new String("world");
		System.out.println(s1 == s2);// false
		System.out.println(s3 == s4);// true
		System.out.println(s1 == s5);// false
		System.out.println(s5 == s6);// false
		System.out.println(s7 == s9);// true
		System.out.println(s7 == s8);// false
		System.out.println(s9 == s8);// false
		System.out.println(s7 == s10);// false
		System.out.println(s7 == s11);// false
		System.out.println("===========");
		System.out.println(s1.equals(s4));// true
		System.out.println(s7.equals(s8));// true
		System.out.println(s7.equals(s9));// true
		System.out.println(s1.equals(s2));// false


	}
}
