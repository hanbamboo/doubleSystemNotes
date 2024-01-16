package com.shuangti.doublepointer;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		rotate(new int[] {1,2,3,4,5,6},2);
	}

	public static void rotate(int[] nums, int k) {
		int[] temp = new int[nums.length];
		System.arraycopy(nums, nums.length - k, temp, 0, k);
		System.arraycopy(nums, 0, temp, k, nums.length - k);
		nums = temp;
	}
}
