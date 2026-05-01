package array;

import java.util.PriorityQueue;
import java.util.Queue;

public class Largest3Elements {
	public static void main(String[] args) {

		int[] arr = { 4, 8, 1, 2, 0, 5, 9 };// 5,8,9

		int k = 3;
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			q.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] > q.peek()) {
				q.remove();
				q.add(arr[i]);
			}
		}

		q.forEach(System.out::println);

	}

}
