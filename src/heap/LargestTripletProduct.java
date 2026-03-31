package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestTripletProduct {
	private  static void largestTripletMultiplication(int arr[], int n) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<n ;i++) {
			queue.add(arr[i]);
			if(queue.size()<3) {
				System.out.println(-1);
			}else {
				int x = queue.poll();
				int y = queue.poll();
				int z = queue.poll();
				int ans = x*y*z;
				System.out.println(ans);
				queue.add(x);
				queue.add(y);
				queue.add(z);
				
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        largestTripletMultiplication(arr, n);
	}
}

/*

Input : arr[] = {1, 2, 3, 4, 5}
Output :-1
        -1
         6
         24
         60
Explanation : for i = 2 only three elements 
are there {1, 2, 3} so answer is 6. For i = 3
largest three elements are {2, 3, 4} their
product is 2*3*4 = 24 ....so on  


*/