package com.shuangti.test01;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 泛型：泛指某一种类型，如果某一个类接口方法加了泛型， 在使用时不指定类型默认为Object类 如果把泛型指定为某一种，那么他的相关的元素类型都为此类型
		 * 用法：1.泛型可以加在类上 
		 * 			public class 类名<泛型变量>{
		 * 				
		 * 			}
		 * 			泛型变量是用来接收数据类型
		 * 				E element
		 * 				T type
		 * 		2.泛型可以加再方法上 
		 * 				修饰符列表<泛型变量> 返回类型 方法名(){
		 * 					
		 * 				} 
		 * 		3.泛型可以加再接口上 
		 * 		4.泛型通配符：？
		 * 			下限限定：? super 类名; ？对应的类型必须是super后面类及其子类
		 *    		上限限定：? extends 类名; 
		 */
		Example01<String> example01 = new Example01();
		example01.setName("dddddd");
		Example02 example02 = new Example02();
		example02.test(13456);
	}
	

}