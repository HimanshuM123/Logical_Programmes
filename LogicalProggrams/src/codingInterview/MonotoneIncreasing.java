package codingInterview;

/*
 * 30/200
      ^     ^    
 {0,1,0,1,1,0}->{0,1,1,1,1,1}  2 flips 
 
 */
public class MonotoneIncreasing {
	public static void main(String[] args) {
		String s = "010110";
		int result = minFlips(s);
		System.out.println(result);
		
	}
	
	private static int minFlips(String s) {
		int ans =0; int prevOnes=0;
		for(char c:s.toCharArray()) {
			if(c=='0') {
				ans = Math.min(ans+1, prevOnes);
			}else {
				++prevOnes;
			}
		}
		return ans;
	}

}
