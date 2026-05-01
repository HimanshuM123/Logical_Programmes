package leetCode;

public class ContainsDuplicate {
public static void main(String[] args) {
	ContainsDuplicate d = new ContainsDuplicate();
  int [] arr = {1,1,1,3,3,4,3,2,4,2};
  System.out.println(d.containsDuplicate(arr));
	
}
public boolean containsDuplicate(int[] nums) {
    boolean flag = false;
	for(int i =0; i< nums.length;i++) {
		for(int j=0;j<nums.length;j++) {
			if(i==j) {
				continue;
			}
			if(nums[i]==nums[j]) {
				flag= true;
			}
		}
	}
	return flag;
}


}
