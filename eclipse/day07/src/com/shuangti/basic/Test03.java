package com.shuangti.basic;

public class Test03 {
	public static void main(String[] args) {
		//形参实参必须类型一致
		//sum("10", 20);
		//sum方法中a、b就是形参,调用方法中传入到的参数
		//addString("aa",10);
		//个数一致
		//循序一致
		//addString(10,"aa");
		//long a = 10;
		//long b = 10000000000l;
		//自动类型转换
		//////
		
		//传递的数组的地址，在调用testArr时
		//形参接收到数组的地址，然后根据地址找到对应的数组
		//将数组存放在堆当中的数据数据改变了，但是实际arr中指向的地址未改变
		//那么main方法调用testArr结束时，
		//还是根据地址去堆里找之前的数组
		//这时候只有第二个数字被改变了
		int[] arr = {1,2,3,4,5};
		System.out.println(arr[1]);
		testArray(arr);
		System.out.println(arr[1]);
		//int d 是main中的参数，调用add的时候传递的参数是值
		//add方法中用形参接收，改变形参的值对main当中的d没影响；
		int a = 10;
		System.out.println(a);
		add(a);
		System.out.println(a);
		
		
	}
	/*
	 * 求和
	 */
	public static int sum(int a,int b) {
		return a+b;
	}
	/*
	 * 拼接字符串
	 * 
	 */
	private static String addString(String a,int b) {
		return a+b;
	}
	/*
	 * 
	 */
	public static long mutiple(long a,long b) {
		return a*b;
	}
	/*
	 * change 2 of the array for 10
	 */
	public static void testArray(int[] arr) {
		arr[1] =10;
		
	}
	/*
	 * 数字加1
	 */
	public static void add(int a) {
		a++;
	}
	
}
