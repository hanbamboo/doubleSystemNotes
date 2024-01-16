package com.shuangti;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test01 {
	/*
	 * Map接口 map他是双链接的，数据是以键值对（key,value）的形式存在的。 
	 * 1.key值不能重复（hashCode和equals）
	 * 2.key、value都可以为空 
	 * 3.key、value放入是无序的 
	 * 方法： 
	 * 		put(Object object)存值 
	 * 		get(Object key)通过键值获取value值 
	 * 		keySet()获取map的所有key值，放入set集合
	 * 		values获取map所有value值放入collection集合 
	 * HashMap的遍历：（获取map的key、value值）
	 * 1.通过key、set获取所有key值 通过get方法获取value 2. 通过map.Entry<k,v>来遍历
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "111");
		map.put(2, "222");
		map.put(3, "333");
		map.put(4, "444");
//  通过key找value
		System.out.println(map.get(3));
//  获取map中所有的键值
		Set<Integer> set = map.keySet();
		System.out.println(set);
		for (Integer s : set) {
			System.out.println(s);
		}
//  获取map当中所有的value
		map.values();
		Collection<String> values = map.values();
		System.out.println(values);

		System.out.println(map);

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("qaz", "wsx");
		map1.put("edc", "rfv");
		map1.put("tgb", "yhn");
		map1.put("ujm", "ik");
		map1.put("ujm", "p");
		map1.put(null, null);
		System.out.println(map1);
//  System.out.println("key="+key+"value="+value);
//  1.通过key、set遍历
		Set<String> s1 = map1.keySet();
		for (String s : s1) {
			System.out.println(s + "==" + map1.get(s));

		}
//  2.迭代器遍历
		Iterator<String> it = s1.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(map1.get(key) + "==" + map1.get(values));

		}
//  3.使用map的Entry对象
//  Set<User> uset=new  HashSet<User>();把它认为是一个对象，
//  这个对象所对应的类型是一个map.Entry类型，然后这个类型有key,value属性
//  可以让他还有相应的get、set方法。
//  Map.Entry相当于存放在另一个class中的对象
//  一个entry对象就是key,value的组合
		Set<Map.Entry<String, String>> entries = map1.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
	}

}