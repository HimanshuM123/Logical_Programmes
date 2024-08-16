package stacksAndQueues;

import java.util.LinkedList;
import java.util.List;

class GenerateParanthesis {
	 static List<String> res = new LinkedList<>();
	public static void main(String[] args) {
		List<String> result =generateParenthesis(3);
		System.out.println(result);
		//[((())), (()()), (())(), ()(()), ()()()]
	}
   

    public static List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, n);
        return res;
    }

    private static void dfs(StringBuilder sb, int close, int n) {
        // Base case: if no open or close parentheses left
        if (n == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }

        // Add an open parenthesis if we still have some available
        if (n > 0) {
            sb.append('(');
            dfs(sb, close + 1, n - 1);
            sb.setLength(sb.length() - 1);
        }

        // Add a close parenthesis if there's a matching open one
        if (close > 0) {
            sb.append(')');
            dfs(sb, close - 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
