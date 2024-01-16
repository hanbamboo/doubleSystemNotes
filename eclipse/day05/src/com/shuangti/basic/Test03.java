
package com.shuangti.basic;
//第二种数组声明方式(动态初始化)
public class Test03 {
	public static void main(String[] args) {
		//33代表着age数组的数据个数(数组长度)
		//这种方式也存值，不同数据类型不同默认值
		//整形默认0；浮点型默认0.0；布尔型默认false
		//引用数据类型:null
		int[] age = new int[33];
	
		//重新赋值，存值
		age[0] =1;
		for (int i = 0; i < age.length; i++) {
			age[i]=i;
		}
		for (int i = 0; i < age.length; i++) {
			System.out.println(age[i]);
		}
		//获取数组长度
		//数组变量名.length,length不是最大下标,就是数组数据个数
		int[] high = {1,2,3,4,5,6,7,8,9,10};
		for (int i : high) {
			System.out.println(i);
		}
		
	}
}
