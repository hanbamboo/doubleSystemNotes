package com.shuangti.duoxianc;

public class Test02 {
    public static void main(String[] args) {
        Run2 run2 = new Run2();
        Thread thread1 = new Thread(run2, "兔子");
        Thread thread2 = new Thread(run2, "乌龟");
        thread1.start();
        thread2.start();
    }
}
