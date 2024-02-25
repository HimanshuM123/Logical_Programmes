package practice2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;

public class Practice2 {
	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60 };
		rotateArray(arr, 4);
		System.out.println(Arrays.toString(arr));

	}

	private static void rotateArray(int[] arr, int k) {
		int n = arr.length;
		reverseArr(arr, 0, k - 1);
		reverseArr(arr, k, n - 1);
		reverseArr(arr, 0, n - 1);

	}

	private static void reverseArr(int arr[], int start, int end) {

		while (start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}

	}
//10, 7, 8, 1, 8, 7, 6 };
}
//10, 20, 30, 40, 50, 60 
// 40 , 30 , 20 ,10 , 50 , 60
// 40 , 30 , 20 , 10 , 60 , 50

//[50, 60, 10, 20, 30, 40]
