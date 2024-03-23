package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import binaryTree.BinaryTreeMirror;
import binaryTree.BinaryTreeSum;
import leetcode2.LinkedListPalimdrom;

public class Practice2 {

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		
		Stack<String> stk = new Stack<>();
		String operators ="+-*/";
		
		for(String obj : tokens ) {
			if(!operators.contains(obj)) {
				stk.push(obj);
			}else {
				int a = Integer.parseInt(stk.pop());
				int b = Integer.parseInt(stk.pop());
				if(obj =="+") {
					int sum = a+b;
					System.out.println("sum"+sum);
					stk.push(String.valueOf(sum));
				}if(obj =="-") {
					int sub = a-b;
					stk.push(String.valueOf(sub));
				}if(obj =="*") {
					int mul = a*b;
					stk.push(String.valueOf(mul));
				}if(obj =="/") {
					int div = b/a;
					stk.push(String.valueOf(div));
				}
				
			}
						
		}
		System.out.println(stk.pop());
		
	}

}
