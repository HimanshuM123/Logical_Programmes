package leetcode2;

import java.util.Arrays;

public class SumClosestToZero {
	public static void main(String[] args) {

		int arr[] = { 1, 3, -5, 7, 8, 20, -40, 6 };
		 Arrays.sort(arr); // -40 -5 1 3 6 7 8 20
		 
		int sum = 0;
		int minimumSum = Integer.MAX_VALUE;
		int length = arr.length;
		int l = 0;
		int r = length - 1;

		int minleft = l;
		int minright = r;

		
		while (l < r) {
			sum = arr[l] + arr[r];

			if (Math.abs(sum) < Math.abs(minimumSum)) {
				minimumSum = sum;
				minleft = l;
				minright = r;
			}
			if (sum < 0)
				l++;
			else
				r--;
		}
		System.out.println(" The pair whose sum is minimun : " + arr[minleft] + " " + arr[minright]);

	}
}
