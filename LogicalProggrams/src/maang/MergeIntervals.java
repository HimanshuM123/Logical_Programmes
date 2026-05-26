package maang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		
		int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		
		int [][] result =	merge(intervals);
		
	}

	
	public static int[][] merge(int[][] intervals) {
	    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
	    List<int[]> result = new ArrayList<>();
	    for (int[] interval : intervals) {
	        if (result.isEmpty() || result.get(result.size()-1)[1] < interval[0]) {
	            result.add(interval);
	        } else {
	            result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
	        }
	    }
	    return result.toArray(new int[0][]);
	}
}
