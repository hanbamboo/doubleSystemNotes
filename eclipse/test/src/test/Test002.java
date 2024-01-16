package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test002 {
	static int[][] game = new int[9][9];
	public static int[][] lineTolie(int[][] cells) {// 行与列互换

		int temp = 0;
		for (int j = 0; j < 9; j++) {
			for (int k = j + 1; k < 9; k++) {
				temp = cells[k][j];
				cells[k][j] = cells[j][k];
				cells[j][k] = temp;

			}
		}
		return cells;

	}
	public static void printGame() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(game[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		
			int[] tmp = crateNoRepList();
			for (int i = 0; i < 9; i++) {
				game[0][i] = tmp[i];
			}
		
		printGame();
		game = lineTolie(game);
		printGame();
//		for (int i = 0; i < 9 ; i++) {
//			System.out.println(Arrays.toString(crateNoRepList()));
//		}
		
	}
	
	
	
	public static int[] crateSudoku() {
		int[] list = new int[9];
		list = crateNoRepList();

		System.out.println(Arrays.toString(list));
		
		for (int i = 0; i < 3; i++) {
			int tmp = list[0];
			for (int j = 0; j < 2; j++) {
				list[j+1] = list[j];
			}
			list[list.length-1] = tmp;
		}
		System.out.println(Arrays.toString(list));

		return list;
	}
	/*
	 * 生成无重复列
	 */
	public static int[] crateNoRepList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			int randomNum = random.nextInt(9) + 1;
			while (true) {
				if (!list.contains(randomNum)) {
					list.add(randomNum);
					break;
				}
				randomNum = random.nextInt(9) + 1;
			}
		}
		int[] numlist = new int[9];
		for (int i = 0; i < list.size(); i++) {
			numlist[i]=list.get(i);
		}
//		System.out.println("生成无重复列：");
//		for (int i : numlist) {
//			System.out.print(i+" ");
//		}
		
		
		return numlist;

	}
	
}
