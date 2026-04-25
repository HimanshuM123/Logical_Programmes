package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		
		int[] arr = { 4, 8, 1, 2, 0, 5, 9 };// 5,8,9
		
		int k=3;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<k;i++) {
			pq.add(arr[i]);
		}
		
		for(int i=k; i<arr.length;i++) {
			if(arr[i]>pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		System.out.println(pq);
		
		
		

	}
	
	
			
			
			
	
	
	
}

