package algorithmsBasics;

import java.util.Arrays;

public class ArrayRotate1 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		rotateArray(arr,4);
		System.out.println(Arrays.toString(arr));
	}

	public static void rotateArray(int[] a, int k) {
		int n=a.length;
		reverseArray(a, 0, k - 1);
		reverseArray(a, k, n - 1);
		reverseArray(a, 0, n - 1);
	}

	public static void reverseArray(int[] a, int start, int end) {
//		for (int i = start, j = end; i < j; i++, j--) {
//			int temp = a[i];
//			a[i] = a[j];
//			a[j] = temp;
//		}
		int left_ptr=start;
		int right_ptr = end;
		while(left_ptr<right_ptr) {
			int temp = a[left_ptr];
			a[left_ptr] = a[right_ptr];
			a[right_ptr] = temp;
			left_ptr++;
			right_ptr--;
		}
	}
}
//10, 20, 30, 40, 50, 60 

// ----------
//40,30,20,10,50,60 <- step1
//            -----
//40,30,20,10,60,50 <- step2
//50, 60, 10, 20, 30, 40 <- step3


