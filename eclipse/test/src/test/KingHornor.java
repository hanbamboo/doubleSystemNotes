package test;

import java.util.Scanner;

public class KingHornor {
	public static void main(String[] args) {
		User user = new User("QQ","张三",10);
		user.login("张三");
		
		Scanner scanner = new Scanner(System.in);
		String key="";
		boolean flag = false;
		while (!key.equals("quit")) {
			if (!flag) {
				startGame();
			}
			key = scanner.next().toString();
			switch (key) {
			case "1":
				System.out.println("打游戏");
				flag=true;
				chooseGameMode();
				String tmp = scanner.next().toString();
				
				break;
			case "2":
				System.out.println("冲点券");
				flag=true;
				break;
			case "3":
				System.out.println("买英雄");
				flag=true;

				break;
			case "4":
				System.out.println("买皮肤");
				flag=true;

				break;
			default:
				flag=false;

				break;
			}
			
		}
		
		
		
		
	}
	public static void startGame() {
		
	
		
		
		System.out.println("序号\t名称");
		System.out.println("1\t打游戏");
		System.out.println("2\t冲点券");
		System.out.println("3\t买英雄");
		System.out.println("4\t买皮肤");

	}
	public static void chooseGameMode() {
		System.out.println("序号\t名称\t介绍");
		System.out.println("1\t匹配\t5v5");
		System.out.println("2\t乱斗\t3v3");
	}
	
}
