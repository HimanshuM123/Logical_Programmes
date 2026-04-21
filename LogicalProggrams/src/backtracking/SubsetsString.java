package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsString {
	public static void main(String[] args) {

		subsets("abc", 0, new ArrayList<>());
	}

	private static void subsets(String str, int index, List<String> current) {
		// print current subset
		System.out.println(current);

		for (int i = index; i < str.length(); i++) {
			current.add(str.charAt(index)+""); // choose
			subsets(str, i + 1, current); // explore
			current.remove(current.size() - 1); // undo (BACKTRACK)
		}
	}
}

/*

[]
[a]
[a, b]
[a, b, c]
[a, b]
[a]
[a, c]
[a]



*/