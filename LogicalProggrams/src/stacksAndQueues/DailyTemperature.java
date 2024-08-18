package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
	public static void main(String[] args) {
		int [] arr = {73,74,75,71,69,72,76,73};
		int [] result = dailyTemperatures(arr);
		System.out.println(Arrays.toString(result));

	}
	
	 public static int[] dailyTemperatures(int[] temperatures) {
	        int[] res = new int[temperatures.length];
	        Stack<Pair> stack = new Stack<>(); // pair: (temp, index)

	        for (int i = 0; i < temperatures.length; i++) {
	            int t = temperatures[i];
	            while (!stack.isEmpty() && t > stack.peek().temp) {
	            	Pair stackElement = stack.pop();
	              //  int stackT = stackElement[0];
	                int stackInd = stackElement.index;
	                res[stackInd] = i - stackInd;
	            }
	            stack.push(new Pair(t, i));
	        }

	        return res;
	    }
	 
	 private static class Pair {
			int temp;
			int index;

			Pair(int temp, int index) {
				this.temp = temp;
				this.index = index;
			}
	 }
}


/*

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

*/