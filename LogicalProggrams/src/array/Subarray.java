package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Given an array arr[] of non-negative integers and an integer sum,
  find a subarray that adds to a given sum.
  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Explanation: Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33
 */
public class Subarray {
	private static List<Integer> findSubarrayWithGivenSum(List<Integer> arr, int sum) {
		Map<Integer,Integer> hm = new HashMap<>();
		List<Integer> subarray = new ArrayList<>();
		int currSum =0;
		for(int i=0; i< arr.size();i++) {
			currSum = currSum + arr.get(i);
			if (hm.containsKey(currSum - sum)) {
                subarray = arr.subList(
                    hm.get(currSum - sum) + 1, i + 1);
                break;
            }
			
			hm.put(currSum, i);
			
		}
		return subarray;
	}
	
	
	public static void main(String[] args) {
		 List<Integer> arr= Arrays.asList(15, 2, 4, 8, 9, 5, 10, 23);	
		 List<Integer> subarray = findSubarrayWithGivenSum(arr, 23);
		 if (subarray.isEmpty()) {
	            System.out.println(
	                "No subarray with given sum found");
	        }
	        else {
	            System.out.print("Subarray: [ ");
	            for (int i : subarray) {
	                System.out.print(i + " ");
	            }
	            System.out.println("]");
	        }
	}

}

//Subarray: [ 2 4 8 9 ]

