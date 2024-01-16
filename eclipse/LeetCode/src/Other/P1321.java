package Other;

import java.util.Scanner;

public class P1321 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		scanner.close();
		int boy = 0, girl = 0;
		String test = a;
		while (test.indexOf("boy") != -1) {
			test = test.substring(test.indexOf("boy") + 3);
			boy++;
		}
		System.out.println(boy);
		test = a;
		while (test.indexOf("girl") != -1) {
			test = test.substring(test.indexOf("girl") + 4);
			girl++;
			
		}
		System.out.println(girl);
	}
}
