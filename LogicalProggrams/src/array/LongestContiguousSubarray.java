package array;

import java.util.HashSet;
import java.util.Set;

public class LongestContiguousSubarray {
    public static void main(String[] args) {
        int[] nums = {49, 1, 3, 200, 2, 4, 70, 5};
    	
        int maxLength = findLengthOfLongestContiguousSubarray(nums);
        System.out.println("Length of the longest contiguous subarray: " + maxLength);
    }

    public static int findLengthOfLongestContiguousSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
//            if (set.contains(num - 1)) {
//                continue;
//            }
            int currentLength = 0;
            while (set.contains(num++)) {
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}

//Length of the longest contiguous subarray: 5
