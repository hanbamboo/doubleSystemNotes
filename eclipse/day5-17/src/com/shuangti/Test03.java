package com.shuangti;

/*
 * Thread类
 * 1.属性
 * 		MAX_PRIORITY线程最大优先级10
 * 		MIN_PRIORITY线程最小优先级1
 * 		NORM_PRIORITY不设置优先级则默认为5
 * 		注意：并不是优先级越高，线程就优先运行，只是提高了当前线程获得cpu资源的概率
 * 2.构造方法
 * 		Thread()无参构造
 * 		Thread(String name)创建线程，并给线程起一个名字
 * 		Thread(Runnable target)传入一个可执行的目标对象来创建一个线程
 * 		Thread(Runnable target,String name)
 * 			传入一个可执行的目标对象来创建一个线程，并给它一个名字
 * 3.静态方法和实例方法
 * 		static void sleep() 休眠
 * 				(让当前线程放弃cpu资源，进入就绪状态，等待执行)
 * 		static void yield()	礼让
 * 				(立即让出CPU资源进入就绪状态和其他线程争夺CPU资源
 *   礼让不一定让成功，有可能礼让的线程还会抢到)
 *   * 实例方法：
 * getName 获取当前线程的名称
 * 主线程的名字就是main
 * 其他线程如果没有设置名称有默认名称System.out.println(Thread.currentThread().getName());获取
 * getPriorrity 获取线程优先级
 * 优先级可以设置，不设置默认为5。
 * 如何给线程设置一个优先级 通过setPriority() 值从1到10
 * 
 *  isDaemon(布尔值)设置线程是否为守护的线程
 * isDaemon判断当前线程是否为守护线程
 * join()插队
 *  如果线程抢到了cpu他会一直执行下去。直到执行结束，才会让给其他线程
 * 注意：关于start（）跟run（）的区别
 * start（）会开启一个线程，会创建一个新的輚内存。
 * run（）是一个普通方法，县城开启，等待cpu调度，cpu执行线程会调用响应的线程对应的run方法。
 * sleeo和wait（）面试点，课下了解一下（0
 * sleep是线程终端的方法，但是wait是object的方法。
 * 2.sleep方法不会释放lock，但是wait会释放，而且回加入到等待队列之中。
 * sleep不会依赖同步器synchronize，但是wait需要一来synchronize
 * sleep不需要被唤醒（休眠之后会推出阻塞），但是wait需要（不指定时间需要被别人中断
 *   
 */
public class Test03 {
	public static void main(String[] args) {
//		System.out.println(Thread.MAX_PRIORITY);
//		System.out.println(Thread.MIN_PRIORITY);
//		System.out.println(Thread.NORM_PRIORITY);

//		创建线程实例对象，并给当前线程对象起一个别名
//		Thread1111 thread1111 = new Thread1111("123");
//		thread1111.start();
//		System.out.println(Thread.currentThread().getName());
//		System.out.println(thread1111.getName());
//
//		Thread2221 thread2221 = new Thread2221();
//		thread2221.start();
//		for (int j = 0; j < 100; j++) {
//			System.out.println("j===" + j);
//		}
		
		
		Thread11111 thread11111 = new Thread11111();
		thread11111.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("i==" + i);

		}
	}
}
