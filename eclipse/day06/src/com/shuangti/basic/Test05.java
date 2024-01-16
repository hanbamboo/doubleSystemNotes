package com.shuangti.basic;

/*
 * 找出字符串中的a的字符串个数，并输出
 * cdefafjfabjsgansag;
 */
public class Test05 {
	public static void main(String[] args) {
		int count = 0;
		StringBuffer sb = new StringBuffer("skdsjaaadkafajakfa");
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == 'a') {
				count++;
			}
		}
		System.out.println("a的个数是" + count);

		System.err.println("============");

		StringBuffer sb1 = new StringBuffer("ABABDCGDGDEGCGCFEFG");
		String temp = "";
		for (int j = 2; j < sb1.length(); j += 2) {
			String t1= sb1.charAt(j - 2) + "" + sb1.charAt(j-1);
			if (temp.equals(t1)) {
				System.out.println(temp+t1);
			}else {
				temp=t1;
			}
		}

	}
}
