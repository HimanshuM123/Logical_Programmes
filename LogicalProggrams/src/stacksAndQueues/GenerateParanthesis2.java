package stacksAndQueues;


import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis2 {
	public static void main(String[] args) {
		GenerateParanthesis2 obj = new GenerateParanthesis2();
		List<String> result = obj.generateParenthesis(3);
		System.out.println(result);
	}
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backtrack(res, stack, 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder stack, int openN, int closedN, int n) {
        if (openN == n && closedN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append("(");
            backtrack(res, stack, openN + 1, closedN, n);
            stack.deleteCharAt(stack.length() - 1); // remove last char (pop)
        }

        if (closedN < openN) {
            stack.append(")");
            backtrack(res, stack, openN, closedN + 1, n);
            stack.deleteCharAt(stack.length() - 1); // remove last char (pop)
        }
    }
}
