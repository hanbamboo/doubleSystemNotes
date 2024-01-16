package com.shuangti.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

/*
 * 字符流
 * 		通过读写流一次可以读取一个或多个字符
 * 字符输入流：Reader(抽象类)
 * 		FileReader(文件字符输入流)
 * 		BufferedReader(缓冲字符输入流)
 * 字符输出了：Writer(抽象类)
 *  	FileWriter(文件字符输出流)
 * 		BufferedWriter(缓冲字符输出流)
 * 		
 * 		read()读取一个或多个字符
 *  	read()方法是字符对应的十进制返回
 *  		read（char[] c） 一次读取指定个数字符，返回实际读取到的字符个数
 * 			读取不到的返回 -1
 * 
 * 
 * 
 * 1.FileReader实现文件读取操作
 * 		1.创建FileReader对象(构造方法)
 * 		2.read()读取一个或多个字符
 * 			将字符对应的十进制返回
 * 		3.关闭资源
 */
public class Test03 {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("1.txt");
		System.out.println((char) file.read());
		file.close();
	}
}
