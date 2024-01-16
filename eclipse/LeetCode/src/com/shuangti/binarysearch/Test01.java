package com.shuangti.binarysearch;

//二分查找
public class Test01 {
	public static void main(String[] args) {
		int a = search(new int[] {1,2,7,12,5,3,4,6},3);
//		System.out.println(a);
	}
	
	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
