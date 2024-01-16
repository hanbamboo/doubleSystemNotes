package test;

import java.util.Random;
import java.util.Scanner;

public class text {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int num_random = random.nextInt(50);
		int num_guess;
		do {
			int num_input = scanner.nextInt();
			num_guess = ((num_input==num_random)?0:(num_input>num_random)?1:-1);
			switch(num_guess){
				case 0 :
					System.out.println("等于");
					break;
				case 1:
					System.out.println("大于");
					break;
				case -1:
					System.out.println("小于");	
					break;		
			}
		}while(num_guess!=0);
		scanner.close();
	}
}


