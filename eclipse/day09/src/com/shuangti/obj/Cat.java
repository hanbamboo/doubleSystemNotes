package com.shuangti.obj;
/**
 * 先掌握方法的定义和调用，其他可以选择性放弃
 * 能定义出来，能穿值，能调用出来，能接受返回值就可以了
 *
 */
public class Cat {
	// 属性
	String name;
	String color;
	int age;
	int weight;
	String sex;

	// 方法
	// public static修饰词可以没有
	// 静态方法
	public static void miao() {
		System.out.println("喵喵喵........");
	}

	// 实例方法
	// 需要通过对象才能去调用
	public void catchMouse() {
		System.out.println("抓老鼠.......");
	}

	// 方法中的参数可以为基本数据类型也可以为引用数据类型
	// 引用数据类型就是变量，变量指向一个内存地址
	public void eatFish(int fishNum) {
		System.out.println("一顿能吃" + fishNum + "只鱼");
	}

	public void eatFood(String foodName) {
		System.out.println("猫在吃" + foodName);
	}

	public void eatMouse(Mouse mouse) {
		System.out.println(this.name + "把" + mouse.name + "吃掉了");

	}

	public void drink(int l) {
		System.out.println("猫一次喝了2升水");
		l -= 2;
	}

	public void eating(Food food) {
		System.out.println("猫吃了10斤猫粮");
		food.weight -= 10;
	}
	//方法返回值：可以为基本数据类型和引用数据类型
	// 根据传进来的星期数返回能睡几小时
	// 周一能睡2小时，其他时间能睡1小时
	public int canSleepHours(String weekOfDay) {
		if (weekOfDay.equals("星期一")) {
			return 2;
		} else {
			return 1;
		}
	}
	public void wief() {
		
	}

}
