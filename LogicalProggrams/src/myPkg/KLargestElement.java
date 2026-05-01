package myPkg;

import java.util.PriorityQueue;

public class KLargestElement {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 5, 6, 4 };
		int k =2;

		PriorityQueue<Integer> queqe = new PriorityQueue<>();

		for (Integer o : arr) {
			queqe.add(o);
		}

		while (queqe.size() > k) {
			queqe.remove();

		}

		System.out.println(queqe.peek());
	}
}

//[3,2,1,5,6,4] and k = 2, return 5.