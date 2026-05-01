package interval;

import java.util.Arrays;
import java.util.Stack;

class Interval {

	int start;
	int end;

	Interval() {
		this.start = 0;
		this.end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {

	private static void mergedIntervals(Interval arr[]) {
		if (arr.length <= 0) {
			return;
		}
		Stack<Interval> stack = new Stack<Interval>();
		Arrays.sort(arr, (i1, i2) -> {
			return i1.start - i2.start;
		});
		//System.out.println(arr);
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			Interval top = stack.peek();
			if (top.end < arr[i].start) { // not overlapping
				stack.push(arr[i]);
			} else if (top.end < arr[i].end) { //  overlapping
				top.end = arr[i].end;  //[1,3],[2,6] -> [1,6]
				stack.pop();
				stack.push(top);
			}
		}
		
		while(!stack.isEmpty()) {
			Interval t = stack.pop();
			System.out.println("["+t.start+" , "+t.end+"]");
		}

	}

	public static void main(String[] args) {
		Interval[] arr = new Interval[4];
		arr[0] = new Interval(1, 3);
		arr[1] = new Interval(2, 6);
		arr[2] = new Interval(8, 10);
		arr[3] = new Interval(15, 18);
		mergedIntervals(arr);
	}
}

/*

Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

   -------------
   |           |
-------        |      ------
|  |  |        |     |      |
1  2  3  4  5  6  7  8  9  10  11
*/