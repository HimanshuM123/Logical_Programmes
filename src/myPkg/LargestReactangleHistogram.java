package myPkg;

import java.util.Stack;

public class LargestReactangleHistogram {
	public static void main(String[] args) {
	//	int arr [] = {2,1,5,6,2,3};
		int arr [] = {10,20,30,40,50};
		int result =largestRectangleArea(arr);
		System.out.println("The Area is "+result);

	}
	
	public  static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int i = 0;
		while (i < height.length) {
			// push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// calculate max value when the current height is less than the previous one
				int j = stack.pop();
				int h = height[j];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int h = height[j];
			int w = stack.isEmpty() ? i : i- 1 - stack.peek() ;
			max = Math.max(h * w, max);
		}
		return max;
	}
}



//height = [2,1,5,6,2,3]


/*
	 -|
    | |
    | |
    | |   |
|   | | | |
| | | | | |



*/