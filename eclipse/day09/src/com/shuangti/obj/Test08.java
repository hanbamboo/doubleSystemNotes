package com.shuangti.obj;

public class Test08 {
	public static void main(String[] args) {
		Flower f = new Flower();
		f.hight=10.0;
		for (int i = 0; i < 7; i++) {
			if (i<3) {
				f.jiaoShui();
			}
			f.shiFei();
		}
		System.out.println("高度是"+f.hight);
		
		
		
		
		f.hight=10.0;
		for (int i = 0; i <= 3; i++) {
			for (double j = 0; j <= 6; j+=0.5) {
				if (0.5*j+i==3.0) {
					System.out.println(j+"次和"+i+"次");
				}
			}
		}
		
		
		
		
	}
}
