package com.shuangti;

public class Thread2221 extends Thread {

	@Override
	public void run() {
		System.out.println("Thread2执行开始");
		for (int i = 0; i < 100; i++) {
			System.out.println("i===" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread2执行结束");

	}
}
