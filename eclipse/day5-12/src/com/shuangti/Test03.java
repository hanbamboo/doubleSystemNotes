package com.shuangti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * 
 * 输出流OutputStream
 * 		获取文件输出流可以对文件进行写入操作
 * 		只要掌握两个输出流
 * 			FileOutputStream文件输出流
 * 			BufferedOutputStream文件缓冲流
 * OutputStream需要掌握的抽象方法
 * 		write(int b)一个写入一个字节
 * 		write(byte[] b)一次写入多个字节
 * 		flush()将缓冲区的字节流文件刷新到文件
 * 		close()关闭流
 */
public class Test03 {
	// 打开一个文件流，然后往文件流当中写入文字
	public static void main(String[] args) throws IOException {
		// 这种打开流的方式进行写操作，会将文件当中的数据覆盖掉
		FileOutputStream out1 = new FileOutputStream("1.txt");
		out1.write(100);
		out1.close();
		// 通过构造方法中append参数true或false确定
		// 是否在原有文件的基础上追加数据
		FileOutputStream out2 = new FileOutputStream("1.txt", true);
		out2.write(100);
		

		byte[] b = new byte[3];
		b[0] = 100;
		b[1] = 101;
		b[2] = 103;
		out2.write(b);
		out2.close();
		
	}

}
