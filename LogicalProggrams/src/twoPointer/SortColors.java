package twoPointer;

import java.util.Arrays;

public class SortColors {
	
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 1, 0, 2, 1, 1, 0, 0, 0, 2, 1, 2 };
		int left = 0;
		int right = arr.length-1;
		int curr = 0;
		while (curr <= right) {
			if (arr[curr] == 2) {
				swap(arr, curr, right);
				right--;
			} else if (arr[curr] == 1) {
				curr++;
			} else {
				swap(arr, curr, left);
				left++;
				curr++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(int [] arr,int i,int j) {
		
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	

}
//[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2]
