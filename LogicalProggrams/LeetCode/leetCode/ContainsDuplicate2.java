package leetCode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
	
	public static void main (String[] args)
	{
	    int arr[] = { 30,20,330,35};
	    ContainsDuplicate2 d = new ContainsDuplicate2();
	    System.out.println(d.containsDuplicate(arr));
	}
	
	public boolean containsDuplicate(int[] nums) {
	    boolean flag = false;
	    Set<Integer> set = new HashSet<>();
	    for(int i=0;i< nums.length;i++) {
	    	if(set.add(nums[i])==false) {
	    		flag=true;
	    	}
	    }
		return flag;
	}
}


///https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/