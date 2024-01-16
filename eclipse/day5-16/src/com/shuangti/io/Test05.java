package com.shuangti.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
 *字符输出流 writer(抽象类)：一次写入一个或者多个字符的文件
 *      FileWriter(文件字符输出流)
 *     	write()写入字符 写入一个或多个
 *     	flush()刷新       
 *      close()关闭资源
 *      BufferedWriter(缓冲字符输出流)
 * 
 * 字符流本身使用了缓存的机制，所以所有的字符输出流都要写操作执行完，必须要flush()刷新或close()关闭
 * 
 * 1、使用BufferedWriter像文件中写入数据
 * 1.创建一个文件字符输入流（reader类型）对象，指向当前文件
 * 2.给字符输入流对象创建一个缓冲流对象
 * 3.通过缓冲归对象对文件进行读操作
 * 4.close()关闭资源，所有都关闭
 * 缓冲字符输出流和文件字符输出流一样
 * */
public class Test05 {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("1.txt");
		BufferedReader buffer = new BufferedReader(file);
		int a = 0;
		while ((a = buffer.read()) != -1) {
			System.out.println((char) a);

		}
		buffer.close();
	}
}