package Other;

import java.util.Scanner;

public class WenDu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double f = scanner.nextDouble();
		double c = 5 * (f - 32) / 9;
		scanner.close();
		System.out.println("Celsius = " + (int) c);
	}
}
