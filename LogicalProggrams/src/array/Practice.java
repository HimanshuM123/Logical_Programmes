package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		
		Practice solution = new Practice();

	        int[] example1 = {1, 2, 3};
	        System.out.println("Example 1:");
	        System.out.println(solution.permutations(example1)); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

	        int[] example2 = {0, 1};
	        System.out.println("Example 2:");
	        System.out.println(solution.permutations(example2)); // Output: [[0, 1], [1, 0]]
	    
	}
	
	private  List<List<Integer>> permutations(int[] arr ) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> solution = new ArrayList<>();
		dfs(arr,solution,result);
		
		return result;
		
	}
	
	private void dfs(int[] arr, List<Integer> solution,List<List<Integer>> result) {
		if(solution.size()== arr.length) {
			 result.add(new ArrayList<>(solution));
			 return;
		}
		
		for(int i =0; i< arr.length; i++) {
			if(!solution.contains(arr[i])) {
				solution.add(arr[i]);
				dfs(arr,solution,result);
				solution.remove(solution.size()-1);
			}
		}
		
		
		
		
	}

}


// ["bella","label","roller"] => ["e","l","l"]