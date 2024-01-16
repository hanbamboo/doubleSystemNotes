package com.shuangti;

public class Thread1111 extends Thread {

	public Thread1111(String name) {
		super(name);
	}

	public Thread1111() {
	}

	@Override
	public void run() {
		System.out.println(super.getName() + "===");
	}
}
