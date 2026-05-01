package array;

import java.util.Arrays;

public class DutchNationalFlag {
	
	private static void sortArr(int arr[]) {
		int cnt0=0,cnt1=0,cnt2=0;
		
		for(int i=0; i< arr.length;i++) {
			if(arr[i]==0) {
				cnt0++;
			}
			if(arr[i]==1) {
				cnt1++;
			}
			if(arr[i]==2) {
				cnt2++;
			}
		}
		
		int j=0;
		while(cnt0>0) {
			arr[j++]=0;
			cnt0--;
		}
		while(cnt1>0) {
			arr[j++]=1;
			cnt1--;
		}
		while(cnt2>0) {
			arr[j++]=2;
			cnt2--;
		}
		System.out.println(Arrays.toString(arr));
		
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		sortArr(arr);
	}
}

/*
 * Sort an array of 0s, 1s and 2s Input: {0, 1, 2, 0, 1, 2} Output: {0, 0, 1, 1,
 * 2, 2}
 * 
 * Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1} Output: {0, 0, 0, 0, 0, 1, 1, 1,
 * 1, 1, 2, 2}
 * 
 */