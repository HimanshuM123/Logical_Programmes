package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;
import leetcode2.LinkedListPalimdrom;

public class Practice2 {

	public static void main(String[] args) {
		int[] arr = { 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		int target = 12;

		int result = getIndex(arr, target);

		System.out.println("The idex is " + result);

	}

	private static int getIndex(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (target < arr[mid]) {
				high = mid - 1;
			} else if (target > arr[mid]) {
				low = mid + 1;
			} else if(target== arr[mid]){
				return mid;
			}
		}

		return -1;
	}
}
