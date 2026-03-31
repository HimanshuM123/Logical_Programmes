package leetCode;

import java.util.Arrays;

public class RotateArray3 {
	public static void main(String[] args) {
		RotateArray3 r = new RotateArray3();
//		int [] nums = {-1,-100,3,99};
//		r.rotate(nums, 2);
		int [] nums = {1,2,3,4,5,6,7};//=> [5, 6, 7, 1, 2, 3, 4]
		r.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

	 public void rotate(int[] arr, int k) {
		  // If arr is rotated n times then
	        // you get the same array
		 int n=arr.length;
	        while (k > n) {
	            k = k - n;
	        }
	 
	        // Creating a temporary array of size k
	        int temp[] = new int[n - k];
	 
	        // Now copying first N-K element in array temp
	        for (int i = 0; i < n - k; i++)
	            temp[i] = arr[i];
	 
	        // Moving the rest element to index zero to D
	        for (int i = n - k; i < n; i++) {
	            arr[i - n + k] = arr[i];
	        }
	 
	        // Copying the temp array element
	        // in original array
	        for (int i = 0; i < n - k; i++) {
	            arr[i + k] = temp[i];
	        }
	 }
}
