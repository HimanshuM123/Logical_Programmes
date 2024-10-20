package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		int[] arr = {  11, 15,2, 7 };// 2,7,11,15
		int target = 9;
		int [] indexes = twoSumIndex(arr, target);
		System.out.println(Arrays.toString(indexes));

	}
	
	public static int []  twoSumIndex(int [] arr , int target) {
		int [] res = new int[2];
		
		Arrays.sort(arr);
		
		int left =0;
		int right = arr.length-1;
		
		while(left < right) {
			int sum = arr[left]+arr[right];
			if(sum > target) {
				right--;
			}else if(sum <target) {
				left++;
			}else {
				res[0]=arr[left];
				res[1]=arr[right];
				break;
			}
			
			
			
			
		}
		
		return res;
		
		
	}

}


// ["bella","label","roller"] => ["e","l","l"]