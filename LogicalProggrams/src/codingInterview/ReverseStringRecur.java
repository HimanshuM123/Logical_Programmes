package codingInterview;

import java.util.Arrays;

public class ReverseStringRecur {
	
	public static void main(String[] args) {
		char[] arr = {'H','E','L','L','O'};
		
		
		reverse(arr,0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	
	private static void reverse(char[] arr, int left , int right) {
		if(left >=right)return;
		swap(arr,left,right);
		reverse(arr,left+1,right-1);
		
		
		
		
	}
	
	private static void swap(char[] arr, int left , int right ) {
		
		 char temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	}

}
