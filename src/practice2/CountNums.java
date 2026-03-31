package practice2;

import java.util.Arrays;

public class CountNums {
	public static void main(String[] args) {
		int arr[] = {3,5,8,3,3,5};
		Arrays.sort(arr);
		
		//3,3,3,5,5,8
		
		int left = 0;
		int right =0;
		int count=0;
		
		while(right <= arr.length-1) {
			if(arr[left] != arr[right] || right==arr.length-1) {
				System.out.println(arr[left]+"  "+count);
				left=right;
				count=0;
				}
			if(arr[left] == arr[right]) {
				right++;
				count++;
			}
		
			
		}
	}

}
