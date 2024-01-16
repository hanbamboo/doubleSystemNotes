package com.shuangti.obj;

/**
 * 变量
 * 类{
 * 		属性：变量
 *  	
 * 		方法
 * }
 * 
 * @变量：成员变量和局部变量
 * 		@成员变量：定义类体当中方法之外的变量
 * 		成员变量 分为实例变量  和  静态变量
 * 			实例变量：对象级别的变量，需要依赖对象来访问的
 * 			静态变量：类级别的变量，比如美国人类的国籍、男人类的性别
 * 				       取决于当前类的变量可以用静态变量来定义
 * 		@局部变量：方法体中声明的变量
 * 			方法体当中的声明局部变量，必须要给默认值或者初值（系统规定）
 * 			方法中的形参变量，也可以是局部变量
 * 			
 * 
 * @方法：实例方法 和 静态方法
 * 		实例方法：对象级别的方法，需要创建对象才能调用"引用."的方式调用
 * 		静态方法：类级别的方法，无需创建对象，通过"类名.方法()"的方式调用
 * 		注意：静态方法中不能访问实例变量、实例方法
 * 		因为实例变量和方法都是对象级别的，而静态是类级别的，不需要创建对象就可以调用
 * 		这与实例变量、方法相悖
 * 		如果非要访问实例变量或者调用实例方法，就需要在静态方法中创建对象
 * 		实例方法中可以访问实例变量、静态变量，也可以调用实例方法、静态方法
 * @什么时候用静态方法  @什么时候用静态方法
 * 		一般静态方法用在工具类当中
 * 		实例方法：比如考试这个行为
 * 
 * 
 */	
public class Man {
	int age;
	static String sex = "男";
	
	//实例方法
	public void method() {
		this.age = 10;
	}
	//静态方法
	public static void method2() {
		System.out.println("======");
	}
}