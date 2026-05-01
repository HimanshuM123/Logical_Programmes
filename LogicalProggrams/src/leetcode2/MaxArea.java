package leetcode2;

public class MaxArea {
	public static void main(String[] args) {
			int height [] = {1,8,6,2,5,4,8,3,7};
			int max_area = 0;
			int a_ptr=0;
			int b_ptr= height.length-1;
			while(a_ptr<b_ptr) {
				if(height[a_ptr]<height[b_ptr]) {
					max_area = Math.max(max_area, height[a_ptr]*(b_ptr-a_ptr));
					a_ptr++;
				}else {
					max_area = Math.max(max_area, height[b_ptr]*(b_ptr-a_ptr));
					b_ptr--;
				}
			}
			System.out.println( max_area);
			
	}

}

//         |             |
//input [1,8,6,2,5,4,8,3,7]
//		output =49