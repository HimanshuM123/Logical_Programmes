package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class InsertIntervals {
	public static void insertIntervals(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
						Math.max(newInterval.end, interval.end));
			}
		}
		result.add(newInterval);
		result.forEach(o -> System.out.println(o.start+", "+o.end));
	}
	
	public static void main(String[] args) {
		
			Interval[] arr = new Interval[5];
			arr[0] = new Interval(1, 3);
			arr[1] = new Interval(6,9);
			ArrayList<Interval> intervals = new ArrayList<>();
			intervals.add(arr[0]);
			intervals.add(arr[1]);
			Interval newInterval = new Interval(2,5);
			
			
//			
//			arr[0] = new Interval(1, 2);
//			arr[1] = new Interval(3,5);
//			arr[2] = new Interval(6,7);
//			arr[3] = new Interval(8,10);
//			arr[4] = new Interval(12,16);
//			ArrayList<Interval> intervals = new ArrayList<>();
//			intervals.add(arr[0]);
//			intervals.add(arr[1]);
//			intervals.add(arr[2]);
//			intervals.add(arr[3]);
//			intervals.add(arr[4]);
//			
//
//			Interval newInterval = new Interval(4,9);
			
			insertIntervals(intervals,newInterval);
		}
	}

/*

Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
[1,2],[3,10],[12,16].

*/