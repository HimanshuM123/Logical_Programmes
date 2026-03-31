package array
;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		//int [] arr = {1,2,3};
		int [] arr = {1,2,9};
		//int [] arr = {9,9,9};
		//int [] arr = {1,9,9};
		System.out.println(Arrays.toString(pluseOne(arr)));
	}
	
	public static int [] pluseOne(int [] arr) {
		int n = arr.length;
		for(int i=n-1; i>= 0;i--) {
			if(arr[i]<9) {
				arr[i]++;
				return arr;
			}
			arr[i]=0;
			
		}
		int [] new_number =new int[n+1];
		new_number[0]=1;
		return new_number;
	}

}
// [1, 2, 3] => [1, 2, 4]
//[9,9,9] => [1, 0, 0, 0]
// [1,9,9] => [2, 0, 0]


