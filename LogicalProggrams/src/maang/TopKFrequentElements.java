package maang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	/*
	 * 
	 * Input: nums = [1,1,1,2,2,3], k = 2  
				Output: [1,2]
	 * 
	 */
	public static void main(String[] args) {
		
		int [] arr = {10,10,10,20,20,30};
		int k=2;
		
		int [] res = topKFrequent(arr,k);
		
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] topKFrequent(int[] nums, int k) {

		Map<Integer,Integer> map = new HashMap<>();
		
		for(int n : nums) {
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		
		List<Integer>[] bucket = new List[nums.length+1];
		
		for(int key : map.keySet()) {
			int freq = map.get(key);
			if(bucket[freq]==null) {
				 bucket[freq] = new ArrayList<>();
			}
			 bucket[freq].add(key);
		}
		int[] res = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return res;
    }
		
		
	}

