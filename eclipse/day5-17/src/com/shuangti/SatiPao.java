package com.shuangti;

public class SatiPao {
	public static void main(String[] args) {
		GUITUSAIPAO guitusaipao = new GUITUSAIPAO();
		Thread tuzi = new Thread(guitusaipao,"兔子");
		Thread wugui = new Thread(guitusaipao,"乌龟");
		tuzi.start();
		wugui.start();
	}
}
