package com.shuangti;

public class Thread11111 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 10 == 0) {
				System.out.println("让一下让一下让一下");
				Thread.yield();
			}
			System.out.println("奥里给==" + i);

		}
	}
}
