package com.shuangti.obj;

import java.util.Arrays;
import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		int[] score = new int[6];
		Random random = new Random();
		for (int i = 0; i < score.length; i++) {
			score[i] = random.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(score));
		int max = max(score);
		int min = min(score);
		int count = 0;
		int sum = 0;
		for (int i : score) {
			if (i == max || i == min) {
				continue;
			} else {
				count++;
				sum += i;
			}
		}
		System.out.println(sum/count);

	}

	public static int max(int[] array) {
		int max = array[0];
		for (int i : array) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	public static int min(int[] array) {
		int min = array[0];
		for (int i : array) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
}
