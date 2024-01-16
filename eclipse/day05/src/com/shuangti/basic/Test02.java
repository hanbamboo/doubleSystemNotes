package com.shuangti.basic;
/*
 * 第一种数组存取方式(静态初始化)
 */
public class Test02 {
	public static void main(String[] args) {
		//声明
		int[] ages = {10,20,30};
		//取值，取出第三个位置的数
		//数组变量名加下标：ages[3]
		System.out.println(ages[2]);
		//数组越界，取值时下标不能超出数组长度范围；
	}
}
