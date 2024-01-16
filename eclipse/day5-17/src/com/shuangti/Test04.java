package com.shuangti;

/*
 * 线程创建的第二种方式
 * 		1.目标类实现Runnable接口
 * 			重写run方法
 * 		2.实例化目标类，将实例化的对象放入Thred()
 * 			创建一个线程对象
 * 		3.线程对象通过start开启线程
 * 
 * * 这种方式最常用,主要体现在这种借口具有多继承的特点,避免了普通类单继承的局限性
 * 提高了代码的扩展力,降低了耦合性
 * 
 * 线程创建的第三种方式(匿名内部类方式)
    使用Thread类
   new Thread() {
     public void run() {
      System.out.println("++++++");
      
     }
  }.start();
  使用Runnable接口及Thread有参构造
  new Thread(new Runnable) {
  @Override
    public void run() {
     
    }
   }.start();
 * */
public class Test04 {
	public static void main(String[] args) {

		//使用Runnable接口及Thread有参构造
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("13434");
			}
		}).start();
		 
		Thred111111 thread111111 = new Thred111111();
		Thread t1 = new Thread(thread111111);
		t1.start();
		Thred111111 thread111112 = new Thred111111();
		Thread t2 = new Thread(thread111112);
		t2.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println("13434");
			}
		}.start();
	}
}
