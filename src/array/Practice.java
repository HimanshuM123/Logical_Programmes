package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		int n = arr.length;
		int k = 4;
		
		reverse(0,n-1, arr);
		reverse(0,k-1, arr);
		reverse(k,n-1, arr);
		
		
		System.out.println(Arrays.toString(arr));
		
		

	}
	
	private static  int [] reverse(int start, int end,int [] arr) {
		while(start<=end) {
			
			int temp=0;
			temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			
			start++;
			end--;
		}
		return arr;
		
		
	}
	
	
			
			
			
	
	
	//10, 20, 30, 40, 50, 60, 70 =>  40,50,60,70,10, 20, 30

}

