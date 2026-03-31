package hashing;

import java.util.HashMap;
import java.util.Map;

public class Subarray {
	
	private static boolean isSubarray(int [] arr1, int [] arr2) {
		if(arr1.length<arr2.length) {
			return false;
		}
		
		Map<Integer,Integer> freq = new HashMap<>();
		for(int i=0; i< arr2.length;i++) {
			if(freq.get(arr2[i])==null) {
				freq.put(arr2[i], 0);
			}else {
				freq.put(arr2[i], freq.get(arr2[i])+1);
			}
		}
		
		for(int i=0 ; i<arr1.length;i++) {
			if(freq.get(arr1[i])!=null && freq.get(arr1[i])>0) {
				freq.put(arr1[i], freq.get(arr1[i])-1);
			}
		}
		
		for(Map.Entry<Integer, Integer> obj : freq.entrySet()) {
			if(obj.getValue()>0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
	
	public static void main(String[] args) {
		int [] arr1 = {11, 1, 13, 21, 3, 7};
		int [] arr2 = {11, 3, 7, 1};
		boolean result = isSubarray(arr1,arr2);
		if(result) {
		System.out.println("arr2[] is a subset of arr1[]");	
		}else {
			System.out.println("arr2[] is NOT a subset of arr1[]");	
		}
		
	}

}


/*
Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
Output: arr2[] is a subset of arr1[]

*/