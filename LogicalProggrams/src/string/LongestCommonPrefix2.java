package string;

public class LongestCommonPrefix2 {
	
	public static void main(String[] args) {
		LongestCommonPrefix gfg = new LongestCommonPrefix();
		String[] input = {  "geeksforgeeks","geeks", "geek", "geezer" };
		System.out.println("The longest Common Prefix is : " + gfg.longestCommonPrefix(input));
	}

	
	public String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0)
	        return "";
	    return lcp(strs, 0, strs.length - 1);
	}

	private String lcp(String[] strs, int left, int right) {
	    if (left == right)
	        return strs[left];

	    int mid = (left + right) / 2;
	    String lcpLeft = lcp(strs, left, mid);
	    String lcpRight = lcp(strs, mid + 1, right);

	    return commonPrefix(lcpLeft, lcpRight);
	}

	private String commonPrefix(String left, String right) {
	    int min = Math.min(left.length(), right.length());
	    for (int i = 0; i < min; i++) {
	        if (left.charAt(i) != right.charAt(i)) {
	            return left.substring(0, i);
	        }
	    }
	    return left.substring(0, min);
	}

}
