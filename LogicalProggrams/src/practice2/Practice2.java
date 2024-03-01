package practice2;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;
import leetcode2.LinkedListPalimdrom;

public class Practice2 {

	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		Stack<String> st = new Stack<String>();
		String operands = "+-*/";
		// System.out.println(operands.contains("+"));
		for (String obj : tokens) {
			if (operands.contains(obj)) {
				if (obj.equals("+")) {
					Integer val1 = Integer.parseInt(st.pop());
					Integer val2 = Integer.parseInt(st.pop());
					st.push(String.valueOf(val1 + val2));
				}
				if (obj.equals("-")) {
					Integer val1 = Integer.parseInt(st.pop());
					Integer val2 = Integer.parseInt(st.pop());
					st.push(String.valueOf(val1 - val2));
				}
				if (obj.equals("*")) {
					Integer val1 = Integer.parseInt(st.pop());
					Integer val2 = Integer.parseInt(st.pop());
					st.push(String.valueOf(val1 * val2));
				}
				if (obj.equals("/")) {
					Integer val1 = Integer.parseInt(st.pop());
					Integer val2 = Integer.parseInt(st.pop());
					st.push(String.valueOf(val2 / val1));
				}
			} else {
				st.push(obj);
			}
		}
		
		System.out.println(st.peek());

	}
}

// 2+1 
// 3* 3 =9