package com.shuangti;

/*
 * 程序：
 * 		放在本地磁盘(ROM)当中的可行性文件
 * 		比如exe、class文件、sh，bat脚本
 * 进程：
 * 		可执行文件执行，进入内存，就变成了进程
 * 线程：
 * 		程序实现或者完成的各种各样的任务就是线程
 * 		线程是由CPU来统一调度的
 * 
 * 
 * java在线程、进程当中的体现
 * 		1.java程序运行后，其实他是开启了两个线程
 * 			一个是main主线程，来控制其他所有java任务的运行
 * 			一个是jvm垃圾回收线程
 * 		2.如果没有添加线程的时候，主线程其中一个环节出现问题，后续的任务都会受到影响
 * 		3.如果主线程中开启了多个线程，其中某个线程出现问题不影响其他线程
 * 
 * java当中线程的使用方式：
 * 		1.创建线程类，继承Thred，并重写run方法
 * 		2.实例化线程类，调用start方法，开启线程
 */
public class Test01 {
	public static void main(String[] args) {
		System.out.println(3);
		System.out.println(2);
		System.out.println(1);
		System.out.println(0);
	}
}
