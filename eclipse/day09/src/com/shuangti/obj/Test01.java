package com.shuangti.obj;

public class Test01 {
	public static void main(String[] args) {
		
		//方法传参，传递基本数据类型
		Cat cafeiCat = new Cat();
		cafeiCat.name="汤姆";
		cafeiCat.color="咖啡色";
		cafeiCat.age=999;
		cafeiCat.sex="男猫";
		cafeiCat.weight = 500;
//		Cat.miao();
		cafeiCat.catchMouse();
		cafeiCat.eatFish(10);
		cafeiCat.eatFood("奥利给");
		
		//方法传参，传递引用数据类型
		//这时候要定义一个引用变量，然后引用变量
		//指向一个具体的mouse对象，
		//调用eatMouse将引用传递过去
		//注意，这个时候传的是引用，也就是地址
		//地址是指向的对象的地址
		Mouse jerry = new Mouse();
		jerry.name="杰瑞";
		cafeiCat.eatMouse(jerry);
		
		//传参改变的问题
		//1.参数为基本数据类型,传递的是实际的数值
		//方法内传过去的值其实又被重新复制了一份
		int cupWater = 10;
		cafeiCat.drink(cupWater);
		//2.传递引用数据类型
		//传递的是对象的地址，改变了地址指向的对象的属性值
		//都会受到影响
		Food cafeFood = new Food();
		cafeFood.weight = 20;
		System.out.println(cafeFood.weight);
		cafeiCat.eating(cafeFood);
		System.out.println(cafeFood.weight);
		
		
		
		int i = cafeiCat.canSleepHours("星期一");
		System.out.println(i);
	}
}
