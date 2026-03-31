package array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        // mark existing
        for (int n : nums) {
            int i = Math.abs(n) - 1;
            nums[i] = -1 * Math.abs(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	FindDisappearedNumbers sol = new FindDisappearedNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDisappearedNumbers(nums)); // Output: [5, 6]
    }
}
