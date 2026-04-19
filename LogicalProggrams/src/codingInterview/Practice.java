package codingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		int[] arr = { 5, 7, 3, 8, 9 };
		int result = partitionDisjoint(arr);

		System.out.println(result);
	}
	
	
	private static int partitionDisjoint(int [] arr) {
		int ans =1;
		int leftMaxSoFar=arr[0];
		int maxSofar=arr[0];
		
		for(int i=1; i< arr.length; i++) {
			maxSofar = Math.max(maxSofar,  arr[i]);
			if(arr[i]< leftMaxSoFar) {
				ans = i + 1;
				leftMaxSoFar =maxSofar;
			}
		}
	
		return ans;
		
		
		
		
		
	}
	
	

}


