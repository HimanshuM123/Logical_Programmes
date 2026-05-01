package stacksAndQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NGFE {
	Stack<Pair> mystack = new Stack<>(); 
    HashMap<Integer,Integer> mymap = new HashMap<>();
    
	class Pair {
		int data;
		int freq;

		Pair(int data, int freq) {
			this.data = data;
			this.freq = freq;
		}
	}

	void nextGreaterFreq(int[] arr, int[] res) {

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (mymap.containsKey(arr[i])) {
				mymap.put(arr[i], mymap.get(arr[i]) + 1);
			} else {
				mymap.put(arr[i], 1);
			}
		}
		int curr_freq = mymap.get(arr[n - 1]);
		mystack.push(new Pair(arr[n - 1], curr_freq));
		res[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			curr_freq = mymap.get(arr[i]);

			while (!mystack.isEmpty() && curr_freq >= mystack.peek().freq)
				mystack.pop();

			if(mystack.isEmpty()) {
				res[i]=-1;	
			}else {
				res[i]=mystack.peek().data;
			}

			mystack.push(new Pair(arr[i], mymap.get(arr[i])));
		}
	}
	public static void main(String[] args) {
		NGFE obj = new NGFE();
		int[] arr = {1, 1, 2, 3, 4, 2, 1}; 
		 int res[] = new int[arr.length]; 
		obj.nextGreaterFreq(arr, res);
		System.out.println(Arrays.toString(res)); 
	}

}

/*

Given an array, for each element find the value of the nearest element to the right which is having
 a frequency greater than that of the current element. If there does not exist an answer for a position, then make the value ‘-1’.


Input : a[] = [1, 1, 2, 3, 4, 2, 1] 
Output :      [-1,-1,1, 2, 2, 1, -1]  

*/