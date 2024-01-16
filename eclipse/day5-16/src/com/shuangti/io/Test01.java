package com.shuangti.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 缓冲字节流
 * 		缓冲输入字节流
 * 		1.BufferedInputStream
 * 		缓冲输出字节流
 * 		2.BufferedOutputStream
 * 	
 * 使用缓冲字节流进行读取操作
 * 		1.创建一个文件输入字节流，指向文件对象
 * 		2.通过文件字节流创建一个缓冲输入字节流，指向缓冲区
 * 		3.从缓冲区读取字节数据
 * 		4.关闭资源
 * 
 * 
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		FileInputStream input = new FileInputStream("测试文档12M.docx");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(input);

		int a;
		long start = System.currentTimeMillis();
		while ((a = bufferedInputStream.read()) != -1) {
//			System.out.println(a);
		}
		long end = System.currentTimeMillis();
		System.out.println("缓冲字节流耗时" + (end - start));
		bufferedInputStream.close();
		input.close();

		FileInputStream input1 = new FileInputStream("1.png");
		int b;
		long start1 = System.currentTimeMillis();
		while ((b = input1.read()) != -1) {
//			System.out.println(b);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("文件字节流耗时" + (end1 - start1));
		input1.close();
	}
}
