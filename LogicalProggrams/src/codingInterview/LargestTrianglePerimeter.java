package codingInterview;

import java.util.Arrays;
//leetcode 976
public class LargestTrianglePerimeter {
	
	public static void main(String[] args) {
		int [] arr= {2,1,2,4};  
		int result =largestPerimeter(arr);
		System.out.println(result);
	}

	
	private static int largestPerimeter(int [] arr) {
		
		Arrays.sort(arr);//1,2,2,4
		
		for(int i=arr.length-3;i>=0;i--) {
			if(arr[i]+arr[i+1]>arr[i+2]) {
				return arr[i]+arr[i+1]+arr[i+2];
			}
		}
		
		return -1;
	
	}
}



/*


lets suppose triangle of sides a,b,c -- a+b>c


*/