package com.shuangti.high;

/*
 * 枚举类是一种特殊的类
 * 一般情况下如果一个类中只用静态常量，最好把这种类定义为枚举类
 * 枚举类不能实例化
 * 枚举类如何定义
 * 
 * public enum SeasonEnum {
 *		枚举值1,
 *		枚举值2,
 *		枚举值3,
 *		...
 *		枚举值n;
 *	}
 * public enum SeasonEnum {
 *		枚举值1("属性值1","属性值2",...,"属性值n"),
 *		枚举值2("属性值1","属性值2",...,"属性值n"),
 *		枚举值3("属性值1","属性值2",...,"属性值n"),
 *		...
 *		枚举值n("属性值1","属性值2",...,"属性值n");
 *
 *		private 类型 属性1变量名;
 *		private 类型 属性2变量名;
 *		private 类型 属性n变量名;
 *
 *		必须写上
 *		private 当前枚举类的名字(类型对应n个形参变量){
 *			
 *		}
 *	}
 *	枚举类的使用：
 *		1.获取枚举类的枚举值
 *			类名.枚举值名
 *		2.获取枚举类的属性值
 *			类名.枚举值.属性名
 *
 * 
 */
public enum SeasonEnum {
	SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINNER("冬天");

	// 春夏秋冬天都是代表当前枚举类的属性值
	// 既然有属性值，那么该类该类必须要声明一个属性
	public String name;

	private SeasonEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
