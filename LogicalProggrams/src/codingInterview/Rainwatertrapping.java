package codingInterview;

public class Rainwatertrapping {
	public static void main(String[] args) {
		int [] arr = {1,3,1,5,3,7,1,5};
		
		int result = trap(arr);
		
		System.out.println(result);
	}

	
	 private static int trap(int[] height) {
	        int n = height.length;
	        
	        int[] leftMax = new int[n];
	        int[] rightMax = new int[n];
	        
	        // fill leftMax
	        leftMax[0] = height[0];
	        for (int i = 1; i < n; i++) {
	            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
	        }
	        
	        // fill rightMax
	        rightMax[n - 1] = height[n - 1];
	        for (int i = n - 2; i >= 0; i--) {
	            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
	        }
	        
	        int water = 0;
	        
	        // calculate trapped water
	        for (int i = 0; i < n; i++) {
	            water =water + Math.min(leftMax[i], rightMax[i]) - height[i];
	        }
	        
	        return water;
	    }
}


/*


Height
 7 |      █
 6 |      █
 5 |    █ █ █
 4 |    █ █ █
 3 |  █ ███ █
 2 |  █ ███ █
 1 | ████████
    -------------------
       2 2 4 =8

| Index | Height | LeftMax | RightMax | Water |
| ----- | ------ | ------- | -------- | ----- |
| 0     | 1      | 1       | 7        | 0     |
| 1     | 3      | 3       | 7        | 0     |
| 2     | 1      | 3       | 7        | 2 ✅   |
| 3     | 5      | 5       | 7        | 0     |
| 4     | 3      | 5       | 7        | 2 ✅   |
| 5     | 7      | 7       | 7        | 0     |
| 6     | 1      | 7       | 5        | 4 ✅   |
| 7     | 5      | 7       | 5        | 0     |

*/