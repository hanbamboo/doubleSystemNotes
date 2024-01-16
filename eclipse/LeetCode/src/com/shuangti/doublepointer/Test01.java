package com.shuangti.doublepointer;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString( sortedSquares(new int[] {1,2,3,4,5})));
	}
	public static int[] sortedSquares(int[] nums) {
        int l=0,r=nums.length-1;
        int[] res = new int[nums.length];
        int index = nums.length-1;
        while(l<=r) {
        	if (nums[l]*nums[l]>nums[r]*nums[r]) {
        		res[index--] = nums[l]*nums[l];
        		++l;
			}else {
				res[index--] = nums[r]*nums[r];
				--r;
			}
        }
        return res;
        
    }
}
