package com.shuangti.test01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test03 {
	/*
	 * list 是一个有序列表，有序是指放入数据时的顺序，而不是list当中的数据又排序 list是有索引的，collection没有
	 * 
	 * 声明一个list对象常用的方式 list<String> slist=new ArrayList<String>();
	 * 除了继承至collection中的方法，他还有一些独有的方法 比如： 1.get(index) 2.set(index) 3.remove(index)
	 * 4.add(int index,E element) 遍历： (1)根据索引去遍历 (2)使用迭代器 (3)增强for循环
	 * 
	 * 补充：LinkedList的查询效率低，但添加删除效率高，相比于ArrayList 因为他是双向链表结构的
	 * 
	 * 关于常见的数据结构： 栈->先进后出(方法入栈) 队列->先进先出 单向列表->data区（存放数据）、指针区（指向下一个数据的地址）
	 * 双向列表->head区（上一个节点的数据的地址）、data(数据)、tail(下一个节点的数据的地址) 树->根、叶子节点
	 */

	public static void main(String[] args) {
//  声明了一个字符串列表
		List<String> slist = new ArrayList<String>();
		slist.add("11");
		slist.add("22");
		System.out.println(slist.size());
		slist.add("33");
		System.out.println(slist.get(2));
		slist.set(1, "222");
		System.out.println(slist.get(1));
//  报错，索引越界
		slist.remove(2);
//  System.out.println(slist.get(3));

//  1.更具索引便遍历
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(11);
		list1.add(12);
		list1.add(13);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
//  2.使用迭代器
		Iterator<Integer> it = list1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
//  3.增强for循环
		for (Integer i : list1) {
			System.out.println(i);
		}
	}
}
