package com.shuangti.obj;

public class Test02 {
	public static void main(String[] args) {
		//类->对象过程实例化，使用new关键字
//		使用new Studrnt();就是一个对象
//		peng是个引用，指向的是这个对象的内存地址
		
//		.简单理解为"的"的意思
		Student p = new Student();
		System.out.println(p);
		System.out.println(p.age);
		System.out.println(p.name);
//		报错,因为age是非静态变量，实例变量需要依赖对象存在
//		System.out.println(Student.age);
	}
}
