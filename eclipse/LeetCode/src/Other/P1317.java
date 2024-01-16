package Other;

import java.util.Scanner;

public class P1317 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] l = new int[n];
		for (int i = 0; i < l.length; i++) {
			l[i] = scanner.nextInt();
		}
		scanner.close();
		boolean flag = false;
		int count = 0;
		for (int i = 2; i < n; i++) {
			if(l[i] < l[i-1])
	            flag = true;
	            if(l[i] >l[i-1]&& flag==true) // 这里还需要左坡已经形成
	            {
	                count++;
	                flag = false;
	            }
		}
		System.out.println(count);
	}
}
