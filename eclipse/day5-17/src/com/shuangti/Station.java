package com.shuangti;

/*
 * 创建一个售票站，具有多线程的能力，其实就是可以多个线程来跑这一个类的目标对象。
 */
public class Station implements Runnable {
	private static int ticket = 100;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "得到第" + ticket + "票");
					ticket--;
				} else {
					break;
				}
			}

		}

	}

}