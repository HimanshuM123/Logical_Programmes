package stacksAndQueues;

import java.util.Stack;

public class CelebrityProblem {
	public static void main(String[] args) {

		//int a[][] = { { 1, 3, 4 }, { 2, 4, 3 }, { 3, 4, 5 } };

		int arr[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };

//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		findCelebrity(arr);
		
		
	}

	private static void findCelebrity(int arr[][]) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(i);
		}
		
		while(stack.size()>=2) {
			int i = stack.pop();
			int j = stack.pop();
			if(arr[i][j]==1) {
				stack.push(j);
			}else {
				stack.push(i);
			}
		}
		int pot = stack.pop();
		for(int i=0;i<arr.length;i++) {
			if(i!=pot) {
				if(arr[i][pot]==0 || arr[pot][i]==1) {
					System.out.println("none");
					return;
				}
			}
		}
		System.out.println(pot);
	}

}

/*

0, 1, 1, 1 
1, 0, 1, 0 
0, 0, 0, 0  <- 2 is celebrity as he doesnt know anyone & everyone knows him
1, 1, 1, 0

*/