package stacksAndQueues;

import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		String operators = "+-*/";
		int result = evalutePolish(tokens,operators);
		System.out.println(result);
		
	}
	
	private static int evalutePolish(String[] tokens, String operators) {
		Stack<String> stk = new Stack<>();
		for(String obj : tokens) {
			if(!operators.contains(obj)) {
				stk.push(obj);
			}else {
				int a = Integer.parseInt(stk.pop());
				int b = Integer.parseInt(stk.pop());
				if(obj =="+") {
					int c = a+b;
					stk.push(String.valueOf(c));
				}
				if(obj =="-") {
					int c = a-b;
					stk.push(String.valueOf(c));
				}
				if(obj =="*") {
					int c = a*b;
					stk.push(String.valueOf(c));
				}
				if(obj =="/") {
					int c = b/a;
					stk.push(String.valueOf(c));
				}
				
				
			}
		}
		return Integer.parseInt(stk.peek());
		
	}
	
}



//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6