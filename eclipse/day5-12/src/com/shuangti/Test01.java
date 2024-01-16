package com.shuangti;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/*
 * File类相关的几个方法
 * 		getAbsolutePath()可以获取当前实例对象对应的文件或文件夹的绝对路径
 * 		相对路径
 * 			以当前项目为根路径，为参照
 * 		绝对路径:
 * 			对应文件或文件夹以盘符(C盘，D盘等)为根目录所在的全路径
 * 		getName()获取当前实例对象所对应的文件或文件夹的名字
 * 		isDirectory()判断当前实例对象是不是一个文件夹，结果为布尔值
 * 		isFile()判断当前实例对象是不是一个文件，结果为布尔值
 * 		createNewFile()创建的文件所在文件夹目录必须是存在的，不然报错
 * 		mkdir()只能一级目录
 * 		mkdir()创建多级目录
 * 		delete()删除文件、目录
 * 		exists()文件、目录是否存在
 * 		list()获取目录下所有文件、文件夹
 * 		listFiles()获取目录下所有File类
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		File file1 = new File("C:\\Users\\wfgmq\\Desktop\\work\\eclipse\\day5-12\\1.txt");
		File file2 = new File("1.txt");
		File file3 = new File("test");
		File file4 = new File("file01.txt");
		File file5 = new File("file");
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getName());
		System.out.println(file1.isDirectory());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
		System.out.println(file3.isDirectory());
		System.out.println(file3.isFile());
		System.out.println("============");
		System.out.println(file4.createNewFile());
		System.out.println(file5.mkdir());
		System.out.println("============");
		File file6 = new File("test01\\test02\\test03");
		System.out.println(file6.mkdirs());
		File file7 = new File("file01.txt");
		System.out.println(file7.delete());
		File file8 = new File("test01");
		System.out.println(file8.delete());
		File file9 = new File("1.txt");
		System.out.println(file9.exists());
		File file10 = new File(".");
		System.out.println(Arrays.toString(file10.list()));

		File[] files = file10.listFiles();
		for (File file : files) {
			if (file.getName().equals("1.txt")) {
				System.out.println("存在");
			}
		}
	}
}
