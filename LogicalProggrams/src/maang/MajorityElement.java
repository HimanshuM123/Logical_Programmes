package maang;

public class MajorityElement {
	
	public static void main(String[] args) {
		int [] nums = {3,2,3};
		
		int result = majorityElement(nums);
		System.out.println(result);
		
	}
	
	
	private static int majorityElement(int[] nums) {
		
		int count =0; int candidate=0;
		
		for(int obj :nums) {
			if(count ==0) {
				candidate=obj;
			}
			
			if(obj == candidate) {
				count++;
			}else {
				count--;
			}
		}
		return candidate;
		
		
	}
	
	

}
