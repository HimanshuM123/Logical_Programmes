package codingInterview;

import java.util.Arrays;

//28/200
// return just small number from array
public class PreviousPermutation {
	public static void main(String[] args) {
		int [] arr= {3,7,2,3,5,6,8}; // 3687532
		
		int n = arr.length;
		
		int i =n-2;
		
		while(i>0 && arr[i]<=arr[i+1]) {
			i--;
		}
		if(i<0) {
			reverse(0, arr.length-1, arr);
		}
		
		int j =n-1;
		while(arr[j]>=arr[i]) {
			j--;
		}
		
		swap(arr,i,j);
		reverse(i+1,arr.length-1,arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	private static void reverse(int left, int right, int [] arr) {
		while(left<right) {
			int tmp = arr[left];
			arr[left]=arr[right];
			arr[right]=tmp;
			
			left++;
			right--;
		}
	}
	
	private static void swap(int [] arr , int i, int j) {
		int tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		
	}

}
