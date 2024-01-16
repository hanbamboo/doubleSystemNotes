package com.shuangti;

/*
 * 创建线程的第一种方式
 * 		(1)线程属性Priority，代表优先级
 * 			如果不给线程设置优先级，默认是5
 * 			如果设置优先级最大是10，最小是0
 * 			通过setPriority(值)方法给线程设置优先级
 * 			注意：并不是优先级越高，线程就优先运行，只是提高了当前线程获得cpu资源的概率
 * 		(2)线程方法
 * 			实例方法、静态方法
 * 		
 */
public class Test02 {
	/*
	 * 主线程(main)认为是部门经理 主线程创建几个子线程 一组 擦黑板 二组 拖地 三组 浇花
	 */
	public static void main(String[] args) {
		Thread111 thread111 = new Thread111();
		Thread222 thread222 = new Thread222();
		Thread333 thread333 = new Thread333();
		thread111.start();
		thread222.start();
		thread333.start();
		System.out.println("4摸鱼");
	}
}
