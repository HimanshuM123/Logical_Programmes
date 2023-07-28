package array;

import java.util.Arrays;
public class EvenOddArray {
public static void main(String[] args) {
	int [] arr = {1,2,3,4,5,6,7,8,9};
	int result[]=new int[arr.length];
	int j=0;
	for(int i=0;i<arr.length;i++) {
		if(arr[i]%2==0) {
			result[j]=arr[i];
			j++;
		}
	}
	for(int i=0;i<arr.length;i++) {
		if(arr[i]%2!=0) {
			result[j]=arr[i];
			j++;
		}
	}
	System.out.println(Arrays.toString(result));
}
}



// [1,2,3,4,5,6,7,8,9]=> [2,4,6,8,1,3,5,7,9]