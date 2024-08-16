package stacksAndQueues;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args) {

		String result = simplifyPath("/a/b/c/../../");
		System.out.println(result);
	}

	private static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		//StringBuilder cur = new StringBuilder();
		String curr="";
		for (char c : (path + "/").toCharArray()) {
			if (c == '/') {
				if (curr.equals("..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else if (!curr.equals("") && !curr.equals(".")) {
					stack.push(curr);
				}
				//cur.setLength(0); // Reset the current string
				curr="";
			} else {
				curr=curr+c;
			}
		}

		return "/" + String.join("/", stack);
	}
}



/*

/a/b/c/../../ => /a


*/