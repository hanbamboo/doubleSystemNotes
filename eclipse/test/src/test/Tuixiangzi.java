package test;

import java.util.Random;
import java.util.Scanner;

public class Tuixiangzi {
	static String[][] game = new String[10][10];
	static Random random = new Random();
	static boolean gameOver = false;
	static int x =1;
	static int y =1;
	
	

	public static void main(String[] args) {
		
		
		gameOver = false;
		initGame();
		initBody();
		printGame();
		Scanner s = new Scanner(System.in);
		String key ;
		boolean quit = false;
		while (!quit) {
			System.out.print("输入wsad控制方向：");
			key = s.nextLine();
			switch (key) {
			case "W":
			case "w":
				goUp();
				break;
			case "A":
			case "a":
				goLeft();
				break;
			case "S":
			case "s":
				goDown();
				break;
			case "D":
			case "d":
				goRight();
				break;
			case "Q":
			case "q":
				quit = true;
				System.out.println("退出游戏");
				break;
			default:
				break;
			}
			printGame();
			if (gameOver) {
				System.out.println("游戏结束");
				break;
			}
		}
	}
	public static void goDown() {
		if (game[x+1][y].equals(" ")) {
			game[x+1][y]="♟";
			game[x][y]=" ";
			x+=1;
		}else if(game[x+1][y].equals("□")){
			if (game[x+2][y].equals(" ")) {
				game[x+2][y]="♟";
				game[x][y]=" ";
				x+=2;
			}
		}else if(game[x+1][y].equals("█")){
			if (game[x+2][y].equals("□")) {
				game[x+2][y] = game[x+1][y];
				game[x+1][y] = "♟";
				game[x][y] = " ";
				gameOver = true;
				System.out.println("恭喜通关！");
				x+=1;
			}else if (game[x+2][y].equals(" ")) {
				game[x+2][y] = game[x+1][y];
				game[x+1][y] = "♟";
				game[x][y] = " ";
				x+=1;
			}
		}
	}
	
	public static void goUp() {
		if (game[x-1][y].equals(" ")) {
			game[x-1][y]="♟";
			game[x][y]=" ";
			x-=1;
		}else if(game[x-1][y].equals("□")){
			if (game[x-2][y].equals(" ")) {
				game[x-2][y]="♟";
				game[x][y]=" ";
				x-=2;
			}
		}else if(game[x-1][y].equals("█")){
			if (game[x-2][y].equals("□")) {
				game[x-2][y] = game[x-1][y];
				game[x-1][y] = "♟";
				game[x][y] = " ";
				gameOver = true;
				System.out.println("恭喜通关！");
				x-=1;
			}else if (game[x-2][y].equals(" ")) {
				game[x-2][y] = game[x-1][y];
				game[x-1][y] = "♟";
				game[x][y] = " ";
				x-=1;
			}
		}
	}
	
	public static void goLeft() {
		if (game[x][y-1].equals(" ")) {
			game[x][y-1]="♟";
			game[x][y]=" ";
			y-=1;
		}else if(game[x][y-1].equals("□")){
			if (game[x][y-2].equals(" ")) {
				game[x][y-2]="♟";
				game[x][y]=" ";
				y-=2;
			}
		}else if(game[x][y-1].equals("█")){
			if (game[x][y-2].equals("□")) {
				game[x][y-2] = game[x][y-1];
				game[x][y-1] = "♟";
				game[x][y] = " ";
				gameOver = true;
				System.out.println("恭喜通关！");
				y-=1;
			}else if (game[x][y-2].equals(" ")) {
				game[x][y-2] = game[x][y-1];
				game[x][y-1] = "♟";
				game[x][y] = " ";
				y-=1;
			}
		}
	}
	
	public static void goRight() {
		if (game[x][y+1].equals(" ")) {
			game[x][y+1]="♟";
			game[x][y]=" ";
			y+=1;
		}else if(game[x][y+1].equals("□")){
			if (game[x][y+2].equals(" ")) {
				game[x][y+2]="♟";
				game[x][y]=" ";
				y+=2;
			}
		}else if(game[x][y+1].equals("█")){
			if (game[x][y+2].equals("□")) {
				game[x][y+2] = game[x][y+1];
				game[x][y+1] = "♟";
				game[x][y] = " ";
				gameOver = true;
				System.out.println("恭喜通关！");
				y+=1;
			}else if (game[x][y+2].equals(" ")) {
				game[x][y+2] = game[x][y+1];
				game[x][y+1] = "♟";
				game[x][y] = " ";
				y+=1;
			}
		}
	}
	
	// 输出棋盘
	public static void printGame() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				System.out.print(game[i][j]+" ");
			}
			System.out.println();
		}
		if (game[1][1].equals("█")||game[1][8].equals("█")||game[8][1].equals("█")||game[8][8].equals("█")) {
			gameOver = true;
			System.out.println("箱子位于死角，游戏结束");
			return;
		}
	}

	// 生成围墙
	public static void initGame() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				if (i == 0 || i == game[i].length - 1 || j == 0 || j == game.length - 1) {
					game[i][j] = "#";
				} else {
					game[i][j] = " ";
				}
				System.out.print(game[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void initBody() {
		x = random.nextInt(8) + 1;
		y = random.nextInt(8) + 1;
		game[x][y] = "♟";
		while (true) {
			int x_out = random.nextInt(8) + 1;
			int y_out = random.nextInt(8) + 1;
			if (game[x_out][y_out].equals(" ")) {
				//箱子出口
				game[x_out][y_out] = "□";
				break;
			}
		}
		int[] indexBox = {2,3,4,5,6,7};
		while (true) {
			int i = random.nextInt(6);
			int x_box = indexBox[i];
			int y_box = indexBox[i];
			if (game[x_box][y_box].equals(" ")) {
				//箱子
				game[x_box][y_box] = "█";
				break;
			}
		}

	}
}
