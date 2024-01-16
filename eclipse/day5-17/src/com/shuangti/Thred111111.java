package com.shuangti;

public class Thred111111 implements Runnable {

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		System.out.println("=========");
		long end = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + "==" + (end - start));
	}

}
