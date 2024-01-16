package com.shuangti;

import java.io.File;
import java.io.IOException;

/*
 * File类构造方法
 * File(File parent,String child)
 * File(String pathname)
 * File(String parent,String child)
 * File(URL uri)
 */
public class Test04 {
	public static void main(String[] args) {
		// File(String pathname)
		File file1 = new File("C:\\Users\\wfgmq\\Desktop\\work\\eclipse\\day5-11\\src\\com\\shuangti\\1.txt");
		System.out.println(file1);

		// File(File parent,String child)
		File parent = new File("C:\\Users\\wfgmq\\Desktop\\work\\eclipse\\day5-11\\src\\com\\shuangti");
		File child = new File(parent, "1.txt");
		System.out.println(child);

		// File(File parent,String child)
		File file2 = new File("C:\\Users\\wfgmq\\Desktop\\work\\eclipse\\day5-11\\src\\com\\shuangti", "1.txt");
		System.out.println(file2);

	}
}
