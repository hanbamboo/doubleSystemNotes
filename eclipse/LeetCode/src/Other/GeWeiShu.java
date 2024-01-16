package Other;

import java.util.Scanner;

public class GeWeiShu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] num = new int[10];
		while (a!=0) {
			num[a%10]++;
			a/=10;
		}
		scanner.close();
		for (int i = 0; i < num.length; i++) {
			if (num[i]!=0) {
				System.out.println(i+":"+num[i]);
			}
		}
	}
}
