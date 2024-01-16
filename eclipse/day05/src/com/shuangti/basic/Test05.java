package com.shuangti.basic;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		int[] array = { 11, 12, 13, 9, 10, 20, 15 };
		// 最大值
		int max = array[0];
		for (int i : array) {
			if (i > max) {
				max = i;
			}
		}
		System.out.println("max=" + max);
		max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = i - 1;
			}
		}
		System.out.println("maxNum=" + max);
		// 最小值
		int min = array[0];
		for (int i : array) {
			if (i < min) {
				min = i;
			}
		}
		System.out.println("min=" + min);
		// 冒泡
		int temp = 0;
		int[] arraySort = { 11, 12, 13, 9, 10, 20, 15 };
		for (int i = 0; i < arraySort.length; i++) {
			for (int j = 0; j < arraySort.length; j++) {
				if (arraySort[j] > arraySort[i]) {
					temp = arraySort[i];
					arraySort[i] = arraySort[j];
					arraySort[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arraySort));
		int[] array1 = { 11, 12, 13, 9, 10, 20, 15 };
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));
	}
}
