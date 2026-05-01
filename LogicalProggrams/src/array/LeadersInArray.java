package array;

import java.util.Stack;

/*
Write a program to print all the LEADERS in the array. An element is a leader if it is greater 
than all the elements to its right side. And the rightmost element is always a leader. 

Input: arr[] = {16, 17, 4, 3, 5, 2}, 
Output: 17, 5, 2

Input: arr[] = {1, 2, 3, 4, 5, 2}, 
Output: 5, 2
*/
public class LeadersInArray {

	private static void printLeaders(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int length = arr.length;
		stack.push(arr[length - 1]);
		for (int i = length - 2; i > 0; i--) {
			if (arr[i] > stack.peek()) {
				stack.push(arr[i]);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "  ");
		}

	}

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		printLeaders(arr);

	}

}

// 17 5 2 

