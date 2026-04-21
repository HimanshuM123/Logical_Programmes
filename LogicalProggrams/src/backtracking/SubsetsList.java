package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsList {
	public static void main(String[] args) {
		subsets(new int[]{1,2}, 0, new ArrayList<>());
	}
	
	
	private static void subsets(int[] nums, int index, List<Integer> current) {
	    // print current subset
	    System.out.println(current);
	    for (int i = index; i < nums.length; i++) {
	        current.add(nums[i]);              // choose
	        subsets(nums, i + 1, current);     // explore
	        current.remove(current.size() - 1); // undo (BACKTRACK)
	    }
	}

}

/*

[]
[1]
[1, 2]
[2]


void backtrack(parameters) {
    if (base condition) {
        save result;
        return;
    }

    for (each choice) {
        make choice
        backtrack(next state)
        undo choice
    }
}

*/