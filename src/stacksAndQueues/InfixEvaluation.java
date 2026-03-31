package stacksAndQueues;

import java.util.Stack;

public class InfixEvaluation {
	public static void main(String[] args) {
		String exp = "2+(5-3*6/2)";
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			System.out.println(ch);
			if (ch == '(') {
				operators.push(ch);
			} else if (ch == ')') {
				while (operators.peek() != '(') {
					char oprt = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					int opv = operation(v1, v2, oprt);
					operands.push(opv);
				}
				operators.pop();
			} else if (Character.isDigit(ch)) {
				operands.push(ch - '0');
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (operators.size() > 0 && operators.peek() != '('
						&& precedence(ch) <= precedence(operators.peek())) {
					char oprt = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();
					int opv = operation(v1, v2, oprt);
					operands.push(opv);
				}
				operators.push(ch);
			}

		}
		while (operators.size() != 0) {
			char oprt = operators.pop();
			int v2 = operands.pop();
			int v1 = operands.pop();
			int opv = operation(v1, v2, oprt);
			operands.push(opv);
		}
		System.out.println("Result is " + operands.peek());
	}

	public static int precedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*') {
			return 2;
		} else {
			return 2;
		}
	}

	public static int operation(int v1, int v2, char operator) {
		if (operator == '+') {
			return v1 + v2;
		}
		if (operator == '-') {
			return v1 - v2;
		} else if (operator == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}
}

//2+(5- 3 * 6/2) = -2