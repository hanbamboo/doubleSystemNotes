package 三月二十八;

import java.util.Scanner;

public class T20Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		int count = 1;
		for (int i = 1; i > 0; i++) {
			double l = 2 * 0.98;
			double m = l;
			m *= 0.98;
			a = a - 2;
			if (a >= -2) {
				a = a - m;
				count++;
			}
		}
		System.out.println(count);
	}
}
