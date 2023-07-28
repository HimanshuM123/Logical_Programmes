package leetCodePepcoding;
//count elements with strictly smaller & greater elements 
public class CountElements {
public static void main(String[] args) {
	int [] nums = {4,4,4,3,7};
	int max=nums[0];
	int min = nums[0];
	int count =0;
	
	for( int i=0; i<nums.length;i++) {
		if(nums[i]>max) {
			max= nums[i];
		}else if (nums[i]<min) {
			min = nums[i];
		}
	}
	for( int i=0; i<nums.length;i++) {
		if(max>nums[i] && nums[i]>min) {
			count++;
		}
	}

	System.out.println(count);
	
	
}
}


// -3 3 3 90 => 2
//11 7 2 15 => 2
// 4,4,4,3,7 => 3