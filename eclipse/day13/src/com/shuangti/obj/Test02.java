package com.shuangti.obj;

/*
 * 1.多态：编译期一个状态，运行期一个状态、
 * 2.转型：必须 两个类之间存在着继承关系，包括间接继承
 */
public class Test02 {
	public static void main(String[] args) {

		Phone phone = new Phone();
		phone.call();
		HuaWei huaWei = new HuaWei();
		huaWei.nfc();
		huaWei.call();

		// 向上转型，子类对象指向父类引用
		Phone matePhone = new HuaWei();
		matePhone.call();
		// 向下转型，要慎重！！！可能会出现类型转换异常的错误

		
		HuaWei mate61 = (HuaWei) matePhone;
		mate61.nfc();
		// 类型转换异常，因为Mi类和HUAWEI类没有继承关系
//		Mi mi11 = (Mi) matePhone;
		// 上边程序报错，程序被中断了，后面程序就无法继续了
		
		// instanceof是一个运算符
		// A instanceof B -> boolean
		//可以防止强制类型转换的时候出现异常
		System.out.println("===========");
		Phone phone1 = new HuaWei();
		if (phone1 instanceof HuaWei) {
			HuaWei huaWei2 = (HuaWei)phone1;
			huaWei2.nfc();
		}
		if (phone1 instanceof Mi) {
			Mi mi = (Mi) phone1;
			mi.redLine();
		}
		//Phone引用数据类型
		//引用数据类型的默认值为null
		
		
//		null值强制转换时不会出现转换异常
//		但是强转之后的变量也是一个空，后面在使用时可能出现空指针异常
		Phone phone2 = null;
		HuaWei mate9=(HuaWei)phone2;
		
	}
}
