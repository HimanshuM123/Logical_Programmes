package twoPointer;

import java.util.Arrays;

public class RemoveDuplicates3 {
	public static void main(String[] args) {
		//int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3,4 };
		int[] arr = {  1, 1, 2 };
		int length = removeDuplicate(arr);
		System.out.println(length);

		
	}
	
	private static int removeDuplicate(int [] arr) {
		
		int length=arr.length;
		int count=0;
		int left =0; int right=1;
		
		while(right < length) {
			if(arr[left] == arr[right]) {
				count++;
			}else {
				left=right;
			}
		
			right++;
			
		}
		
		return length -count;
		
	}

}
