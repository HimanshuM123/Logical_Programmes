package array;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.PriorityQueue;

public class KthSmallest {
	

	
	    public static int findKthSmallest(int[] arr, int k) {
	        if (arr == null || k <= 0 || k > arr.length) {
	            throw new IllegalArgumentException("Invalid input");
	        }

	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        for (int num : arr) {
	            minHeap.add(num); // Add all elements, including duplicates
	        }

	        // Extract k elements
	        int result = -1;
	        for (int i = 0; i < k; i++) {
	            result = minHeap.poll();
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	        int[] arr = {7, 10, 4, 3, 20, 15, 4, 3, 7};
	        int k = 4;
	        int result = findKthSmallest(arr, k);

	        System.out.println("The " + k + "-th smallest element is: " + result);
	    }


}


/*


int k=3;
int [] arr = {7, 10, 4, 3, 3, 20, 15};

==>7
*/