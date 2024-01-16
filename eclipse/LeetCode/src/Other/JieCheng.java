package Other;

import java.util.Scanner;

public class JieCheng {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int num; 
		int S = 0; 
		for (int i = 1; i <= n; i++) { 
			num = 1; 
			for (int j = 1; j <= i; j++) {
				num *= j; 
			}
			S += num; 
		}
		System.out.println(S); 
	}
}
