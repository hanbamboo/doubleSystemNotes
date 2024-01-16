package com.shuangti.obj;
/*
 * 
 * 构造方法，又称构造器、Constructor
 * 作用：创建对象，然后给对象属性赋值
 * 构造方法的定义
 * 		[修饰符列表] public 当前的类名(形参列表){
 * 			构造方法体
 * 		}
 * 		注意：构造方法是没有返回类型的，即使是void也不能加
 * 构造方法有两种：
 * 		a: 形参列表有参数叫做有参构造
 * 		b: 无参数叫做无参构造(或者空构造)
 * 
 * 如果类当中没有声明构造方法，其实是有一个默认的无参构造(空构造)，
 * 如果类当中声明了构造方法，不管是有参还是无参，系统是不会再默认有一个无参构造了
 * 如果想要调用无参构造创建对象必须显示在类中声明出来
 * 
 */
public class User {
	String name;
	int age;
	//无参构造
	public User() {
		
	}
	//有参构造
	public User(String name,int age) {
		
		this.name = name;
		this.age = age;
	}
	
}
