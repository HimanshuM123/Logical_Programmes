package codingInterview;
//Number: 769
public class MaximumChunksToSoft {
	
	public static void main(String[] args) {
		int [] arr = {1,0,3,2,4,6,5};
		int result = maxChunksToSorted(arr);
		System.out.println(result);
	}
	
	
	private static int maxChunksToSorted(int [] arr) {
		
		int n = arr.length;
		int chunks =0; int max=0;
		
		for(int i=0; i<n ;i++) {
			max = Math.max(arr[i], max);
			
			
			if(max==i) {
				chunks++;
			}
			
		}
	
		
		return chunks;
	}

}


/*

50/200

{[1,0],[3,2],[4],[6,5]} chunks =4

Time complexity O(N)
Space complexity O(1)


*/