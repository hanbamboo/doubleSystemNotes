package com.shuangti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/*
 * 源:(所有IO流相关的类都在java.io下)
 * 		字节输入流(将磁盘当中的文件以字节流的形式读到内存(Java对象)当中)
 * 			InputStream
 * 				下面的抽象方法:
 * 					read()一次读取一个字节
 * 					read(byte[] byte)一次读取多个字节
 * 					close()关闭流
 *				如果想用InputStream下的方法，只能通过他的子类(非抽象类)实例化调用
 *					FileInputStream()文件输流
 *					BufferedInputStream()缓冲输入流
 *				字节流可以成为万能流，所有的文件以字节形式存在
 *				所以字节流可以读写任意类型的文件(txt、jpg、mp3)
 *		FileInputStream构造方法
 *			1.public FileInputStream(String name)
 *				name 是文件所对应的路径
 *
 * 		字节输出流
 * 			OutStream
 * 
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
		// 相当于打开1.txt，然后将文件指向实例对象in
		FileInputStream in = new FileInputStream("1.txt");
		// 读出文件数据
		// UTF-8编码的文字，中文占三个字节
		// GBK占两个字节
		int i = 0;
//		while ((i = in.read()) != -1) {
//			System.out.printf("%c", i);
//		}
//		in.read(byte[] b)一次读几个字节
		byte[] b = new byte[10];
		System.out.println(in.read(b));
		System.out.println(Arrays.toString(b));
		in.close();
	}
}
