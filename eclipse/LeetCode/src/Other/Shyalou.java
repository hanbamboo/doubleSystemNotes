package Other;

import java.util.Scanner;

public class Shyalou {
	static int num = 0;
	static String s = "";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		String[] strings = temp.split(" ");
		num = Integer.parseInt(strings[0]);
		s = strings[1];

		int line = (int) Math.pow(num, 0.5) - 1;

		for (int i = line; i > 0; i--) {
			int k = i;

			int j = 2 * (i - 1) + 1;
			while (k < line) {
				System.out.print(" ");
				k++;
			}
			for (int x = 0; x < j; x++) {
				System.out.print(s);
				num--;
			}
			System.out.println();
		}

		for (int i = 2; i <= line; i++) {
			int k = i;

			int j = 2 * (i - 1) + 1;
			while (k < line) {
				System.out.print(" ");
				k++;
			}
			for (int x = 0; x < j; x++) {
				System.out.print(s);
				num--;
			}
			System.out.println();

		}
		System.out.println(num);
	}

}
