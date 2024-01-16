package Other;

/**
 * 
 * 输入x,y（1582<=x<y<=3000）
 * 输出[x,y]取件的闰年个数，并在下一行输出所有闰年年份数字
 * 输入： 
 * 1989 2001
 * 输出：
 * 3
 * 1992 1996 2000
 */

import java.io.*;
import java.util.*;

public class CountRUN {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.close();
		if (x >= 1582 && x < y && y <= 3000) {
			int count = 0;
			String res = "";
			for (int i = x; i <= y; i++) {
				if (i % 400 == 0) {
					count++;
					res += i + " ";
					continue;
				}
				if (i % 4 == 0 && i % 100 != 0) {
					count++;
					res += i + " ";
				}
			}
			System.out.println(count);
			System.out.println(res);
		}
	}
}
