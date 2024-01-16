package com.shuangti.obj;

public class Test {
	public static void main(String[] args) {
		Cat cafeCat = new Cat();
		cafeCat.age = 10;
		cafeCat.high = 10;
		cafeCat.name = "加菲猫";
		cafeCat.tail = 1;
		
		//方法覆盖OverRide	(重写OverWrite)	，
		//方法重载(在一个类中)
		//重写(在两个类里)
		//重写的条件：
		/*
		 * 1.子类和父类之间，两个类之间存在着继承关系，也包含间接继承、
		 * 2.方法名相同
		 * 3.参数列表相同，跟参数名无关
		 * 4.返回类型相同，返回类型必须严格一致，不会自动转型
		 * 5.访问修饰符并不需要严格一致，访问权限修饰符子类要比父类的大或相同
		 * 最好去父类中将重写的方法copy过来，然后修改方法体
		 */
		//比较、总结一下重载和重写的区别
		
		//为什么要有重写机制
		//主要是有了继承的重写，才有了后面的多态，不然就没有存在的意思
		//
		cafeCat.call();
		cafeCat.catchMouse();
		
		//父类当中的构造方法能不能被重写
	}
}
