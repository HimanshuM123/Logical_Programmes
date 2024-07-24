package string;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] arr) {
		int n = arr.length;
		String result = arr[0];

		for (int i = 1; i < n; i++) {
			while (arr[i].indexOf(result) != 0) {
				result = result.substring(0, result.length() - 1);
//				System.out.println("result " + result);

				if (result.isEmpty()) {
					return "-1";
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LongestCommonPrefix gfg = new LongestCommonPrefix();
		String[] input = {  "geeksforgeeks","geeks", "geek", "geezer" };
		System.out.println("The longest Common Prefix is : " + gfg.longestCommonPrefix(input));
	}
}

/*
geeksforgeeks   geeks

geeksforgeek
geeksforgee
geeksforge
geeksforg
geeksfor
geeksfo
geeksf
geeks

geeks  geek
geek

geek geezer
gee

=gee

*/