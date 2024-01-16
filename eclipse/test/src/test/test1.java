package test;

import java.util.Arrays;

public class test1 { 
	public static void main(String[] args) {
		
		
		
		
		
		String aa = "Hello";
		String bb = "Hello";
		
		System.out.println(Boolean.parseBoolean("TRrue3"));
		String b = "双体软件精英产业学院";
		System.out.println(b.indexOf("精英"));
		int[] oldArray = { -5, 19, 23, 37, 47, 56 };
		int i = Arrays.binarySearch(oldArray, 35);
	
		
		int insertionIndex = -i - 1;
		int[] newArray = new int[oldArray.length + 1];
		for (int index = 0; index < insertionIndex; index++) {
			newArray[index] = oldArray[index];
		} 
		StringBuffer sb = new StringBuffer();
		
//		System.out.println(Arrays.toString(newArray));
		newArray[insertionIndex] = 35;
//		System.out.println(Arrays.toString(newArray));
		for (int index = insertionIndex + 1; index < oldArray.length; index++) {
			newArray[index] = oldArray[index];
		}
		System.out.println(Arrays.toString(newArray));

	}

}
