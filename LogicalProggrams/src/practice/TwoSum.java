package practice;

import java.util.Arrays;

public class TwoSum {
	public static void main(String[] args) {
		int [] arr= {2,7,11,15};
		
		int res[] =twoSum(arr,9);
		System.out.print(Arrays.toString(res));
	}
	
	public static int []  twoSum(int [] arr, int target) {
		
		int [] result = new int[2];
		
		int left =0; int right =arr.length-1;
		while(left<right) {
			
			int num1= arr[left];
			int num2=arr[right];
			int sum = num1+num2;
			if(sum>target) {
				right--;
			}else if(sum < target) {
				left++;
			}else {
				
				result[0]= arr[left];
				result[1]= arr[right];
				return result;
			}
			
			
		}
		
		
		
		
		return result;
		
		
	}

}
