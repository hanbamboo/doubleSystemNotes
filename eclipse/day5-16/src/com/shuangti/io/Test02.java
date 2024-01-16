package com.shuangti.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 缓冲输出字节流
 * 
 * 通过缓冲输出字节流写入数据
 * 		1.通过FileOutputStream创建一个输出字节流对象，指向要写入的文件
 * 		2.给字节流对象创建一个缓冲输出字节流对象，将字节流的数据放入缓冲区
 * 		3.对缓冲区进行写操作，往文件当中写入数据
 * 		4.刷新缓冲区flush
 * 			刷新之后，文件流、缓冲流还可以将继续进行写操作
 * 		5.关闭资源
 * 			相当于flush后关闭
 * 
 * 注意：使用缓冲流进行写操作时必须要flush或者close，不然写不进去数据
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("1.txt");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(file);
		bufferedOutputStream.write(
				"奥利给是一个网络流行词，第一次出现在一名快手主播直播时说的正能量语录里。作为感叹词，包含了赞美、加油打气等多种感情色彩。据2021年12月24日百度指数显示，“奥利给”的最高峰值为36986，整体日均值为2131，移动日均值为1762；资讯最高峰值462709，日均值14762"
						.getBytes());
		bufferedOutputStream.flush();
		bufferedOutputStream.write("奥利给奥利给奥利给奥利给奥利给奥利给奥利给".getBytes());
		bufferedOutputStream.close();
	}
}
