package com.shuangti;

public class GUITUSAIPAO implements Runnable {

	@Override
	public void run() {
		int road = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			road += 5;
			System.out.println(Thread.currentThread().getName() + "跑了一会" + road);

			if (road >= 100) {
				System.out.println(Thread.currentThread().getName() + "跑到了终点");
				break;
			}

		}

	}

}
