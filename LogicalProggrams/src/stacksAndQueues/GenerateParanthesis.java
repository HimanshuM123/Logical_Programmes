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
        dfs("", 0, n);
        return res;
    }

    private static void dfs(String str, int close, int open) {
        // Base case: if no open or close parentheses left
        if (open == 0 && close == 0) {
            res.add(str);
            return;
        }

        // Add an open parenthesis if we still have some available
        if (open > 0) {
        	str=  str+"(";
            dfs(str, close + 1, open - 1);
            str = str.substring(0,str.length()-1); //delete the last element
        }

        // Add a close parenthesis if there's a matching open one
        if (close > 0) {
        	str=  str+")";
            dfs(str, close - 1, open);
            str = str.substring(0,str.length()-1);//delete the last element
        }
    }
}
