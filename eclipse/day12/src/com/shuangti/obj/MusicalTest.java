package com.shuangti.obj;

public class MusicalTest {
	public static void main(String[] args) {
		JiTa jita = new JiTa();
		System.out.println("吉他的声音是" + jita.sound);
		jita.play();

		DiZi dizi = new DiZi();
		System.out.println("笛子的声音是" + dizi.sound);
		dizi.play();
	}
}
