package codingInterview;

import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 5, 6, 4 };

		int k = 3;

		PriorityQueue pq = new PriorityQueue();

		for (int obj : arr) {

			pq.add(obj);
			if (pq.size() > k) {

				pq.poll();
			}

		}

		System.out.println(pq.peek());

	}

}


/*


Time: O(n log k)
Space: O(k)

*/