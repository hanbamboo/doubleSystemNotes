package com.shuangti.test01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 集合中单列集合的顶层接口Collection
 * 如果不指定泛型，则默认存放所有引用数据类型(Object)
 * (1)掌握它的共性方法：
 * 		add()
 * 		remove()
 * 		clear()
 * 		contains()
 * 		empty()
 * 		isEmpty()
 * 		size()
 * 		toArray()
 * (2)遍历
 * 
 * 		1.将集合转为数组，通过数组的方式遍历
 * 		2.迭代器遍历集合
 * 			迭代器就是用来遍历集合的
 * 				通过集合对象调用iterator()方法返回一个迭代器对象
 * 				通过迭代器对象的hasNext()和next()方法来遍历集合中每一个数据
 * 		3.增强for循环(forEach)
 * 			语法:
 * 				for(集合或数组当中存档的对应数据类型 变量名:数组对象/集合对象){
 * 					
 * 				}
 */
public class Test01 {
	public static void main(String[] args) {
		Collection col = new ArrayList();
		col.add(111);
		col.add("22");
		System.out.println(col.size());

//		col.remove("22");
		System.out.println(col.size());

		System.out.println(col.contains(111));

//		  col.clear();
		System.out.println(col.size());
		System.out.println("=================");
		// 2.1通过集合转数组
		Object[] objects = col.toArray();
		for (Iterator iterator = col.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}

		// 2.2 通过 迭代器遍历集合
		Iterator it = col.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}

		// 1.3 增强for循环
		for (Object object : objects) {
			System.out.println(object);
		}
		// 遍历此集合，判断集合当中的数据是不是包含字符串111
		for (Object o : col) {
			// instanceof是一个运输符，来判断当前变量的类型
			// A instanceof B 如果A是B类型结果为true，否则为false
			if (o instanceof String) {
				String S1 = (String) o;
				if (S1.contains("22")) {
					System.out.println("=====");
				}
			}
		}
		Collection<String> col1 = new ArrayList<String>();
		col1.add("111");
	}
}
