package Other;

import java.util.Arrays;
import java.util.Scanner;

public class ResverString {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] a = s.split(" ");
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	}
}
