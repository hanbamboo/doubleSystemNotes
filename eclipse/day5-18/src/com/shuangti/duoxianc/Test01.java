package com.shuangti.duoxianc;

public class Test01 {
    public static void main(String[] args) {
        Run1 run1 = new Run1();
        Thread t1 = new Thread(run1,"一部");
        Thread t2 = new Thread(run1,"二部");
        t1.start();
        t2.start();
    }
}
