package test;

import java.util.Random;
import java.util.Scanner;

public class day0309 {
	final static int SIZE = 10;
	static String[][] game = new String[SIZE][SIZE];
	// 游戏棋盘
	static Random random = new Random(); // 随机数(用来给小人随机定位的)
	static boolean gameOver = false; // 游戏结束标志
	static int x = 1; // 小人坐标
	static int y = 1; // 小人坐标

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		initGame();
		initBody();
		printGame();

		while (!gameOver) {
			System.out.print("操作：");
			String key = s.nextLine();
			switch (key) {
			case "W":
			case "w":
				goUp();
				break;
			case "S":
			case "s":
				goDown();
				break;
			case "A":
			case "a":
				goLeft();
				break;
			case "D":
			case "d":
				goRight();
				break;
			default:
				break;
			}
			printGame();
		}

	}

	public static void goUp() {
		if (game[x - 1][y] == " ") {
			game[x - 1][y] = "Y";
			game[x][y] = " ";
			x -= 1;
		}else if(game[x - 1][y] == "O"){
			
			if (game[x - 2][y] == "*") {
				game[x - 2][y] = "O";
				game[x - 1][y] = "Y";
				game[x][y] = " ";
				x -= 1;
				gameOver=true;
				System.out.println("游戏结束");
			}else if (game[x - 2][y] == " ") {
				game[x - 2][y] = "O";
				game[x - 1][y] = "Y";
				game[x][y] = " ";
				x -= 1;
				
			}
			
			
		}

	}

	public static void goLeft() {
		if (game[x][y - 1] == " ") {
			game[x][y - 1] = "Y";
			game[x][y] = " ";
			y -= 1;
		}else if(game[x ][y- 1] == "O"){
			if (game[x][y - 2] == " ") {
				game[x ][y- 2] = "O";
				game[x][y - 1] = "Y";
				game[x][y] = " ";
				y -= 1;
			}
		}

	}

	public static void goRight() {
		if (game[x][y + 1] == " ") {
			game[x][y + 1] = "Y";
			game[x][y] = " ";
			y += 1;
		}else if(game[x ][y+ 1] == "O"){
			if (game[x][y + 2] == " ") {
				game[x ][y+ 2] = "O";
				game[x][y + 1] = "Y";
				game[x][y] = " ";
				y += 1;
			}
		}

	}

	public static void goDown() {
		if (game[x + 1][y] == " ") {
			game[x + 1][y] = "Y";
			game[x][y] = " ";
			x += 1;
		}else if(game[x + 1][y] == "O"){
			if (game[x + 2][y] == " ") {
				game[x + 2][y] = "O";
				game[x + 1][y] = "Y";
				game[x][y] = " ";
				x += 1;
			}
		}

	}

	public static void printGame() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(game[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void initBody() {
		x = random.nextInt(8) + 1;
		y = random.nextInt(8) + 1;
		game[x][y] = "Y";
		int x_box = random.nextInt(6) + 2;
		int y_box = random.nextInt(6) + 2;
		game[x_box][y_box] = "O";
		int x_over = random.nextInt(6) + 2;
		int y_over = random.nextInt(6) + 2;
		game[x_over][y_over] = "*";
	}

	public static void initGame() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1) {
					game[i][j] = "#";
				} else {
					game[i][j] = " ";
				}
			}
		}
	}

}
