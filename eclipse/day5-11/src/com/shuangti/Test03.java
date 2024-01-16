package com.shuangti;

import java.io.File;

public class Test03 {
	/*
	 * 
	 * File类是java.io下一个文件类
	 * 
	 * 通过此类获取文件或文件夹对象，然后可以对磁盘上的文件或文件夹增删查改
	 * 
	 * 目标： 1.掌握File类的属性 2.掌握File类的构造方法 3.掌握File类中常用的方法 获取文件、文件夹路径 创建文件、文件夹 删除文件、文件夹
	 * 判断文件、文件夹存在 获取指定目录下所有文件、文件夹 （1）File类中的属性 pathSeparator separator
	 * 
	 */
	public static void main(String[] args) {
		// 系统环境的分隔符
		// windows下是分号(;)
		// Linux下是冒号(:)
		System.out.println(File.pathSeparator);
		// 文件路径分隔符
		// 比如C:\Users\wfgmq\Documents\Tencent Files\1203423491
		// windows下是"\" Linux下是"/"
		System.out.println(File.separator);

		// 获取c盘User文件夹下data文件夹的test.txt文件
		// 编写文件路径的时候
		//后续通过路径获取文件或文件夹的时候，一定要检查路径
		String path = "C:" + File.separator + "Users" + File.separator + "wfgmq" + File.separator + "Documents"
				+ File.separator + "Tencent Files" + File.separator + "1203423491";
	
	}
}
