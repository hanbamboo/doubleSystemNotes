package com.shuangti.basic;

import java.util.Arrays;

public class Test07 {
	public static void main(String[] args) {
		//和为13
		int[] array1 = {0,4,9,1,13,17};
		for (int i : array1) {
			for (int j : array1) {
				if (i+j==13) {
					System.out.println(i+"与"+j+"和为13");
				}
			}
		}
		
		
		
//		int[] array111 = {7,2,3,9,10,6,5,4,10,3,1,10};
//		Arrays.sort(array111);
//		System.err.println(Arrays.toString(array111));
//		for (int i = 1; i < array111.length; i++) {
//			if (array111[i]==array111[i-1]) {
//				System.err.println(i);
//			}
//		}
		
		
		
		
		
		
//		//超过两次输出
		int[] array2 = {7,2,3,9,10,6,5,4,10,3,1,10,8,9,3,2,1,3,4,6,2,2};
		int[] array_save = new int[10];
//		System.out.println(Arrays.toString(array2));
		for (int i = 0; i < array2.length; i++) {
			int index = array2[i]-1;
			array_save[index]++;
		}
		for (int i = 0; i < array_save.length; i++) {
			if (array_save[i]>=2) {
				System.out.println(i+1+":"+array_save[i]);
			}
//			System.out.println(i+":"+array_save[i]);
		}
		
		//超过两次输出2
		int[] array2_ = {7,2,3,3,9,10,6,5,4,10,2,9,5,10};
		Arrays.sort(array2_);
		for (int i = 0; i < array2_.length; i++) {
			int count =0;
			for (int j = i+1; j < array2_.length; j++) {
				if (array2_[i]==array2_[j]) {
					count++;
				}else {
					break;
				}
			}
			if (count>0) {
				System.out.println("=="+array2_[i]);
				i=i+count+1;
				
			}
		}
		
		
		//偶数前奇数后
		int[] array3 = {1,4,5,2,7,8};
		Arrays.sort(array3);
		//[7,2,4,1,5,8]
		for (int i = 0; i < array3.length; i++) {
			for (int j = 0; j < array3.length; j++) {
				if (array3[j]%2!=0) {
					int tmp = array3[i];
					array3[i] = array3[j];
					array3[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(array3));
		//倒序输出
		int[] array4 = {11,9,10,3,6,5};
		for (int i = 0,j=array4.length-1;j>=0 && i < array4.length/2; i++,j--) {
			int tmp = array4[j];
			array4[j]=array4[i];
			array4[i] =tmp;
		}
		System.out.println(Arrays.toString(array4));
		
	}
}
