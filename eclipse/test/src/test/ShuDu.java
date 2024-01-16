package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuDu {

	public String[][] make_board(int m) {
		System.err.println("1+1"+1+1);
		String[][] board = null;
		int n = m * m;
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		
		while (board == null) {
			board = get_board(m, numbers);
		}
		return board;
	}

	private String[][] get_board(int m, List<Integer> numbers) {
		int n = m * m;
		String[][] board = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean ok = true;
				// 打乱顺序
				Collections.shuffle(numbers);
				for (int x = 0; x < n; x++) {
					if (isOk(numbers.get(x) + "", board, i, j, m)) {
						board[i][j] = numbers.get(x) + "";
						ok = false;
						break;
					}
				}
				if (ok) {
					return null;
				}
			}
		}
		return board;
	}

	public void print_board(String[][] board, int m) {
		int n = m * m;
		int hard = 5;
		String[][] b = new String[n][n];
		System.arraycopy(board, 0, b, 0, board.length);
		Random rd = new Random();
		for (int i = 0; i < hard; i++) {
			for (int j = 0; j < n; j++) {
				int x = rd.nextInt(9);
				b[x][j] = null;
			}
		}
		String spacer = "+-----+-----+-----+-----+-----+-----+-----+-----+-----+";
		System.out.println(spacer);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (null == board[i][j]) {
					System.out.print("| |");
				} else {
					System.out.print("| " + b[i][j] + " |");
				}
			}
			System.out.println();
			System.out.println(spacer);
		}
	}

	/**
	 * 判断行列和9格里是否重复
	 * 
	 * @param x
	 * @param board
	 * @return
	 */
	private boolean isOk(String x, String[][] board, int i, int j, int m) {
		int i0 = i - i % m, j0 = j - j % m;
		int n = m * m;
		for (int k = 0; k < n; k++) {
			if (x.equals(board[i][k]) || x.equals(board[k][j])) {
				return false;
			}
		}
		for (int k = i0; k < i; k++) {
			for (int g = j0; g < j0 + m; g++) {
				if (board[k][g].equals(x)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ShuDu s = new ShuDu();
		int m = 3;
		String[][] b = s.make_board(m);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		s.print_board(b, m);
	}
}
