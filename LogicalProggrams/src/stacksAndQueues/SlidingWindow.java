package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindow {
	public static void main(String[] args) {
//		int[] arr = { 2, 9, 3, 8, 1, 7, 12, 6, 14, 4 };
		int[] arr = { 0,1,2,3,4,5,6,7};
		int k=4;
		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();

		st.push(arr.length - 1);
		nge[arr.length - 1] = arr.length;

		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				nge[i] = arr.length;
			} else {
				nge[i] = st.peek();
			}
			st.push(i);
		}
		System.out.println("arr => "+Arrays.toString(arr));
		System.out.println("nge => "+Arrays.toString(nge));
		
		for (int i = 0; i <= arr.length - k; i++) {
			int j=i;
			while(nge[j]< i + k) {
				j= nge[j];
			}
			System.out.println(arr[j]);
		}

	}

}

//9,9,8,12,12,12,14,12,4