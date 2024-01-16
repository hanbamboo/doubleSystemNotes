package com.shuangti.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
 *字符输出流 writer(抽象类)：一次写入一个或者多个字符的文件
 *      FileWriter(文件字符输出流)
 *     write()写入字符 写入一个或多个
 *     flush()刷新       close()关闭资源
 *        BufferedWriter(缓冲字符输出流)
 * 
 * 字符流本身使用了缓存的机制，所以所有的字符输出流都要写操作执行完，必须要flush()刷新或close()关闭
 * 
 * 1、使用FileWriter像文件中写入数据
 * 1.创建一个文件字符输出流对象
 * 2.write()方法写入一个或多个字符
 * 3.flush()
 * 4.close()
 * 
 * */
public class Test04 {

	public static void main(String[] args) throws IOException {
		// true代表是否追加的意思，他可以不写，不写默认覆盖
		FileWriter file = new FileWriter("D:\\my.txt", true);
		file.write("我是谁");
		file.flush();
		file.close();
	}
}
