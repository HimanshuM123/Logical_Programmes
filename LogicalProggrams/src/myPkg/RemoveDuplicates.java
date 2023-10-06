package myPkg;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] arr = { 2,1,1,3 };

		// 1,1,2,3
		int result[] = removeDuplicates(arr);
		System.out.println(Arrays.toString(result));
	}

	private static int[] removeDuplicates(int[] arr) {

		Arrays.sort(arr);
		int i=0;
		int j=1;
		
		while(j < arr.length) {
			if(arr[i]==arr[j] ){
				j++;
				
			}else {
				i++;
				arr[i]=arr[j];
				j++;
				
			}
		}
		int result [] = new int[i+1];
		for(int k=0;k<=i;k++) {
			result[k]=arr[k];
		}
	
		return result;
		

	}

}
