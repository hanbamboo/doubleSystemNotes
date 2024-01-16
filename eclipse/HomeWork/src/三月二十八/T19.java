package 三月二十八;

import java.util.Scanner;

public class T19 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = 0;
		if (a <= 150) {
			b = a * 0.4463;
		} else if (a >= 151 && a <= 400) {
			b = 150 * 0.4463;
			b += (a - 150) * 0.4663;
			// 150及以下的部分算进去
			// 150以上的再算一次
		} else {// 如果都不满足就代表大于400
			b = 150 * 0.4463;
			b += (400 - 150) * 0.4663;
			b += (a - 400) * 0.5663;
			// 150及以下的部分算进去
			// 150到400以上的再算一次
			// 多于400的再算最后一次
		}
		System.out.printf("%.1f", b);
		scanner.close();
	}
}
