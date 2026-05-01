package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {
	private static void kSort(int[] arr, int n, int k) {
		if (arr == null || arr.length == 0) {
			return;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int minCount = Math.min(arr.length, k + 1);
		for (int i = 0; i < minCount; i++) {
			queue.add(arr[i]);
		}
		int index =0;
		for(int i=k+1;i<n;i++) {
			arr[index++]=queue.peek();
			queue.poll();
			queue.add(arr[i]);
			
		}
		 Iterator<Integer> itr = queue.iterator();
		 
	        while (itr.hasNext()) {
	            arr[index++] = queue.peek();
	            queue.poll();
	        }
	}
	 
	 private static void printArray(int [] arr, int n) {
		 for(int i=0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
		
	 }
	
	public static void main(String[] args) {
		 int k = 3;
	        int arr[] = { 2, 6, 3, 12, 56, 8 };
	        int n = arr.length;
	 
	      
	        kSort(arr, n, k);
	        printArray(arr, n);
	}

}


/*
Given an array of N elements, where each element is at most K away from its target position,
 devise an algorithm that sorts in O(N log K) time.
Input: arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3 
Output: arr[] = {2, 3, 5, 6, 8, 9, 10}
*/