package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "Helloworld";
		String b = "Hello";
		String c = "Hello";

		String d = b + c;
		System.out.println(a == d);
		System.out.println(getUrlEncode("头疼"));

	}

	public static String getUrlEncode(String str) throws UnsupportedEncodingException {
		return URLEncoder.encode(str, "UTF-8");
	}
}
