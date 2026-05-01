package array;

import java.util.Arrays;

public class RearrangeArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int[] temp = arr.clone();

		int left_index = 0;
		int right_index = arr.length - 1;
		boolean flag =true;

		for(int i=0; i< arr.length;i++) {
			if(flag) {
				arr[i]=temp[right_index--];
			}else {
				arr[i]=temp[left_index++];
			}
			flag=!flag;
		}
		
		System.out.println(Arrays.toString(arr));

	}
}

/*
 * 
 * Rearrange an array in maximum minimum form using Two Pointer Technique Input:
 * arr[] = {1, 2, 3, 4, 5, 6, 7} Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
 * 
 * Input: arr[] = {1, 2, 3, 4, 5, 6} Output: arr[] = {6, 1, 5, 2, 4, 3}
 * 
 * 
 */