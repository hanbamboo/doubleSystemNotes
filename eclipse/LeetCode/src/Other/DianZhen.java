package Other;

import java.util.Scanner;

//洛谷 P1319 压缩技术
public class DianZhen {
	public static void main(String[] args) {
		int n = 0, t = 0, m = 0, s = 0;
		int a = 0;
		Scanner in = new Scanner(System.in); 

		n = in.nextInt();
		while (s < n * n) {
			a = in.nextInt();
			t++;
			for (int b = a; b >= 1; b--) {
				if (m == n) {
					System.out.println();
					m = 0;
				}
				if (t % 2 == 1) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
				m++;
				s++;
			}
		}
		System.out.println();

	}

	

}
