package array;

import java.util.Arrays;

public class MoveZeros {
	public static void main(String[] args) {
		int arr[] = { 1,0,2, 0, 3 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count<arr.length) {
			arr[count++]=0;
		}
		
		System.out.print(Arrays.toString(arr));
	

	}

}
