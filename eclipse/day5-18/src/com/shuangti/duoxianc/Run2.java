package com.shuangti.duoxianc;

public class Run2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            if (Thread.currentThread().getName().equals("兔子")) {
                if (i % 10000000 == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "到达终点");
    }
}
