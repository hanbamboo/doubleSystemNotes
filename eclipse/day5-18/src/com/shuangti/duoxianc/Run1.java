package com.shuangti.duoxianc;

public class Run1 implements Runnable {
    public final String a = "投影仪";
    public final String b = "翻页笔";

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("一部")) {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "拿到了投影仪");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "拿到了翻页笔");
                    System.out.println(Thread.currentThread().getName() + "可以彩排了");
                }
            }
        }else {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "拿到了翻页笔");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "拿到了投影仪");
                    System.out.println(Thread.currentThread().getName() + "可以彩排了");
                }
            }
        }
    }
}
